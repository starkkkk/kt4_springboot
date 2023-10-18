package com.pojo;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.thymeleaf.standard.processor.StandardAltTitleTagProcessor;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Resource
public class CompetitionMatrixService {
    // 最大迭代次数
    private static final Integer iterMax = 50;
    // 分类数目
    private static final Integer NUM_CATEGORY = 15;
    // 转发最小阈值
    private static final Integer REPOST_THRESHOLD = 50;

    @Resource
    private JdbcTemplate jdbcTemplateHIT;

    /**
     * 使用梯度下降法进行计算
     *
     * @param startDate 开始时间
     * @return          竞争矩阵，未归一化
     */
    public double[][] drawBySGD(Date startDate) {
        Long OneWeekMillis = 1000L * 7 * 24 * 3600;
        Date endDate = new Date(startDate.getTime() + OneWeekMillis);
        System.out.println("LOADING DATA from " + startDate + " to " + endDate + "...");

        List<MessageInfo> infoList = new ArrayList<>();
        String sqlWeiboOrigin = "SELECT * FROM weibo_origin WHERE posttime >= " +
                String.valueOf(startDate.getTime()) +
                " AND posttime <= " +
                String.valueOf(endDate.getTime());
        System.out.println(sqlWeiboOrigin);
        List<WeiboOrigin> weiboOrigins = jdbcTemplateHIT.query(sqlWeiboOrigin, new BeanPropertyRowMapper<>(WeiboOrigin.class));

        System.out.println("Weibo Fetched === " + weiboOrigins.size() + " === items");
        for (WeiboOrigin weiboOrigin : weiboOrigins) {
            if (Integer.parseInt(weiboOrigin.getRepostnum()) > REPOST_THRESHOLD) {
                MessageInfo info = new MessageInfo();
                info.setMid(weiboOrigin.getId());
                info.setTruePop(Integer.valueOf(weiboOrigin.getRepostnum()));
                info.setProbs(getProbWithoutCalc(weiboOrigin));
                info.setPredict(getPredictWithoutCalc(weiboOrigin));
                infoList.add(info);
            }
        }

        // 所有微博的期望值，用于验证
        Double truePop = 0D;
        Double predPop = 0D;
        double probArray[] = new double[NUM_CATEGORY];

        // 所有微博的概率分布期望向量， q
        for (MessageInfo messageInfo : infoList) {
            truePop += messageInfo.getTruePop();
            predPop += messageInfo.getPredict();
            List<Double> probs = messageInfo.getProbs();
            for (int iter = 0; iter < probs.size(); iter++) {
                probArray[iter] = probArray[iter] + probs.get(iter);
            }
        }
        for (int iter = 0; iter < NUM_CATEGORY; iter++) {
            probArray[iter] /= infoList.size();
            truePop /= infoList.size();
            predPop /= infoList.size();
        }

        // 最终需要返回的竞争矩阵， M
        double[][] M = new double[NUM_CATEGORY][NUM_CATEGORY];

        for (int i = 0; i < NUM_CATEGORY; i++) {
            for (int j = 0; j < NUM_CATEGORY; j++) {
                Random random = new Random();
                M[i][j] = random.nextDouble();
            }
        }

        // SGD过程
        for (int iter = 0; iter < iterMax; iter++) {
            // 当前微博的概率分布， p
            double probP[] = new double[NUM_CATEGORY];
            for (int item = 0; item < infoList.size(); item++) {
                // 获取item的概率分布
                for (int i = 0; i < NUM_CATEGORY; i++) {
                    probP[i] = infoList.get(item).getProbs().get(i);
                }
                double[][] MUpdated = paramUpdateBySGD(probP, probArray, M);
                M = MUpdated.clone();
            }

            /**
             * 验证计算的 M 是否可以 收敛
             * 计算最后一个微博用于验证 预测热度 是否可收敛
             */
            System.out.println("true Popularity: " + truePop);
            System.out.println("Predicted Popularity: " + predPop + calcDelta(M, probP, probArray));
        }

        return M;
    }

    /**
     * delta = p.T * M * q
     * p是15 * 1 的 列向量， M是15 * 15 的矩阵， delta是标量， LaTex表示如下：
     *
     * @param p $p \in \mathbb{R} ^ {15}$
     * @param q $q \in \mathbb{R} ^ {15}$
     * @param M $M \in \mathbb{R} ^ {15 \times 15}$
     *          <p>
     *          对式子                $\delta = p^{\mathsf{T}}Mq$
     *          定义损失函数如下，      $l=\frac{1}{2}||\delta||^2=\frac{1}{2} \delta^{\mathsf{T}}\delta = \frac{1}{2}(p^{\mathsf{T}}Mq)^{\mathsf{T}}(p^{\mathsf{T}}Mq)$
     *          对损失函数求导，有      $\frac{\partial{l}}{\partial M} = qq^{\mathsf{T}}M^{\mathsf{T}}pp^{\mathsf{T}}$
     * @return M
     */
    private double[][] paramUpdateBySGD(double[] p, double[] q, double[][] M) {
        // learning rate
        double lr = 1e-2;
        // Nd4j创建的是行向量
        INDArray pTensor = Nd4j.create(p).transpose();
        INDArray qTensor = Nd4j.create(q).transpose();
        INDArray MTensor = Nd4j.create(M);

        INDArray grad = qTensor.mmul(qTensor.transpose()).mmul(MTensor.transpose()).mmul(pTensor).mmul(pTensor.transpose());
        INDArray MTensorRes = MTensor.sub(grad.mul(lr));

        double[] doubles = MTensorRes.data().asDouble();
        // reshape
        double[][] mResult = new double[NUM_CATEGORY][NUM_CATEGORY];
        for (int i = 0; i < NUM_CATEGORY; i++) {
            for (int j = 0; j < NUM_CATEGORY; j++) {
                mResult[i][j] = doubles[i * NUM_CATEGORY + j];
            }
        }
        return mResult;
    }

    private double calcDelta(double[][] M, double[] p, double[] q) {
        double sum = 0;
        for (int i = 0; i < NUM_CATEGORY; i++) {
            for (int j = 0; j < NUM_CATEGORY; j++) {
                sum += p[i] * M[i][j] * q[j];
            }
        }
        return sum;
    }

    /**
     * 获取微博的概率分布， 直接从数据库获取
     * @param weiboOrigin   微博原文
     * @return              概率分布
     */
    private List<Double> getProbWithoutCalc(WeiboOrigin weiboOrigin) {
        if (weiboOrigin == null) {
            System.out.println("No Message...");
            return null;
        }
        String probStr = weiboOrigin.getProb();
        if (probStr.length() < 2) {
            return null;
        }
        String probs = probStr.substring(1, probStr.length() - 1);
        String[] probArray = probs.split(",");
        ArrayList<Double> probList = new ArrayList<>();
        for (String prob : probArray) {
            double probValue = Double.parseDouble(prob);
            probList.add(probValue);
        }
        return probList;
    }

    /**
     * 使用正文前10条历史正文的转发量期望值作为该正文的预测热度值
     * @param weiboOrigin   正文
     * @return              正文的预测热度
     */
    private Double getPredictWithoutCalc(WeiboOrigin weiboOrigin) {
        if (weiboOrigin == null) {
            return null;
        }
        double meanPopularity = 0;
        List<Integer> reposts = null;
        try {
            String sqlWeiboFormerTenReposts = "SELECT repostnum FROM weibo_origin WHERE posttime >= " +
                    weiboOrigin.getPosttime() +
                    " and uid = " +
                    weiboOrigin.getUid() +
                    " ORDER BY posttime DESC LIMIT 10";
            reposts = jdbcTemplateHIT.query(sqlWeiboFormerTenReposts, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("repostnum");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (reposts == null || reposts.isEmpty()) {
            System.out.println("No History Data...");
            return 0D;
        } else {
            for (Integer repost : reposts) {
                meanPopularity += repost;
            }
            return meanPopularity /= reposts.size();
        }
    }

    /**
     * @param array 未归一化矩阵
     * @return      归一化结果
     */
    public double[][] normalization(double[][] array) {
        Integer DIM = NUM_CATEGORY;
        Double max = Double.NEGATIVE_INFINITY;
        Double min = Double.POSITIVE_INFINITY;

        Double minNew = 0D;
        Double maxNew = 100D;

        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
        }
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                // 归一化到[0, 1]范围
                double norm = (array[i][j] - min) / (max - min);
                // 缩放到[minNew, maxNew]范围
                array[i][j] = norm * (maxNew - minNew) + minNew;
            }
        }
        return array;
    }
}