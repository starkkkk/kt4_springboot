package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.pojo.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hk1Controller {

    @Resource
    private JdbcTemplate jdbcTemplateOne;

    @Resource
    private JdbcTemplate jdbcTemplateTwo;

    @Resource
    private JdbcTemplate jdbcTemplateThree;

    @Resource
    private JdbcTemplate jdbcTemplateFour;

    @Resource 
    private JdbcTemplate jdbcTemplateFive;

    @Resource 
    private JdbcTemplate jdbcTemplateSix;

    @Resource
    private JdbcTemplate jdbcTemplateHIT;

    @Resource
    private CompetitionMatrixService competitionMatrixService;

    @Resource
    private JdbcTemplate jdbcTemplateChen;

    @Resource
    private JdbcTemplate jdbcTemplateZheng;
    /**
     * 基于指标体系的意见领袖发现
     * @return      所有的意见领袖
     */
    @RequestMapping(value = "/kols/getAll",method = RequestMethod.GET)
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<Kol> getAll(){
        String sqlKol = "select * from kol where 1 = 1";
        // 查询HIT库中的kol表
        List<Kol> kols = jdbcTemplateHIT.query(sqlKol, new BeanPropertyRowMapper<>(Kol.class));
        return kols;
    }

    @RequestMapping(value = "/kols/categories",method = RequestMethod.GET)
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public Map<String, List<Kol>> getCategories() {
        String sqlKol = "select * from kol where 1 = 1";
        // 查询HIT库中的kol表
        List<Kol> kols = jdbcTemplateHIT.query(sqlKol, new BeanPropertyRowMapper<>(Kol.class));
        Map<String, List<Kol>> kolCatMap = new HashMap<>();
        for (Kol kol : kols) {
            String domain = kol.getKoldomain();
            List<Kol> domainKols = kolCatMap.get(domain);
            if (domainKols == null || domainKols.isEmpty()) {
                domainKols = new ArrayList<>();
            }
            domainKols.add(kol);
            kolCatMap.put(domain, domainKols);
        }
        return kolCatMap;
    }


    /**
     * 基于内容生成
     * @param domain    领域
     * @return          根据领域对应选择的评论语料
     */
    @RequestMapping("/reply/selectByDomainAndEvent")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<Review> selectByDomain(String domain, String event){
//        String sqlReview = "select * from review where domain = \"" + domain +
//                "\" and event = \"" + event + "\" limit 10000";
        String sqlReview = "select * from review where domain = \"" + domain + "\";";
        System.out.println(sqlReview);
        List<Review> reviews =  jdbcTemplateHIT.query(sqlReview, new BeanPropertyRowMapper<>(Review.class));
        System.out.println("REQUEST ACCOMPLISH!");
        return reviews;
    }
    /**
     * 基于内容生成的引导策略
     * 查询条件包含所有四个类目
     * @param domain    类目一
     * @param event     类目二
     * @param tagL1     类目三
     * @param tagL2     类目四
     * @return          根据查询条件返回所有评论内容
     */
    @RequestMapping("reply/selectByAllFourTags")
    @CrossOrigin(allowedHeaders = "*", origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public List<Review> selectByAllFourTags(String domain, String event, String tagL1, String tagL2) {
        String sqlReview = "select * from review where domain = \"" + domain + "\"";
        if (event != null) {
            sqlReview += " and event = \"" + event + "\"";
        }
        if (tagL1 != null) {
            sqlReview += " and tagL1 = \"" + tagL1 + "\"";
        }
        if (tagL2 != null) {
            sqlReview += " and tagL2 = \"" + tagL2 + "\";";
        }

        System.out.println(sqlReview);
        List<Review> reviews =  jdbcTemplateHIT.query(sqlReview, new BeanPropertyRowMapper<>(Review.class));
        System.out.println("REQUEST ACCOMPLISH!");
        return reviews;
    }
    /**
     * 基于竞争传播热度消减
     * @param startDate 时间窗口开始时间（时间窗口为1周）
     * @return          时间窗口内的竞争矩阵（15 * 15）
     * @throws IOException
     */
    @RequestMapping("/competition/calc")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public double[][] matrixCalculation(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate) throws IOException {
        System.out.println(startDate);
        String sqlMatrix = "SELECT * FROM competition_matrix" +
                " WHERE startDate = \"" +
                new SimpleDateFormat("yyyy-MM-dd").format(startDate) + "\"";
        System.out.println(sqlMatrix);
        List<CompetitionMatrix> matrices = jdbcTemplateHIT.query(sqlMatrix, new BeanPropertyRowMapper<>(CompetitionMatrix.class));
        if (matrices == null || matrices.isEmpty()) {
            return null;
        }
        CompetitionMatrix competitionMatrix = matrices.get(0);
        String normMatrixValue = competitionMatrix.getNormMatrixValue();
        double[][] doubleMatrix = new double[15][15];
//        处理返回的二维数组字符串
        normMatrixValue = normMatrixValue.substring(1, normMatrixValue.length() - 2);
        String[] rowArr = normMatrixValue.split("], ");

        for (int i = 0; i < 15; i++) {
            String row = rowArr[i].substring(1);
            String[] colArr = row.split(", ");
            for (int j = 0; j < 15; j++) {
                String numStr = colArr[j];
                double num = Double.parseDouble(numStr);
//                将 -100 至 100 的数据转换成 0 - 100
                num = (num + 100) / 2;
                doubleMatrix[i][j] = num;
            }
        }
        System.out.println(Arrays.deepToString(doubleMatrix));
        return doubleMatrix;
    }

    @RequestMapping("/getData")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public String showTablesData(@RequestParam("n") int n) {
        // 查询event_01表数据的sql
        String sqlevent1 = "select * from event_01 limit " + n;
        // 查询event_02表数据的sql
        String sqlevent2 = "select * from event_02 limit " + n;
        // 查询weibo1表数据的sql
        String sqlweibo1 = "select * from weibo1 limit " + n;
        // 查询weibo2表数据的sql
        String sqlweibo2 = "select * from weibo2 limit " + n;
        // 查询leader1表数据的sql
        String sqlleader1 = "select * from leader1 limit " + n;
        String sqlleader2 = "select * from leader2 limit " + n;
        String sqlleader3 = "select * from leader3 limit " + n;
        String sqlleader4 = "select * from leader4 limit " + n;
        String sqltrack1 = "select * from tracking1 limit " + n;
        // 查询第一个库中的event表
        List<EventOne> eventOneList = jdbcTemplateOne.query(sqlevent1, new BeanPropertyRowMapper<>(EventOne.class));
        // 查询第一个库中的event表
        List<EventTwo> eventTwoList = jdbcTemplateOne.query(sqlevent2, new BeanPropertyRowMapper<>(EventTwo.class));

        // 查询第二个库中的微博表
        List<WeiboOne> weiboOneList = jdbcTemplateTwo.query(sqlweibo1, new BeanPropertyRowMapper<>(WeiboOne.class));
        // 查询第二个库中的微博表
        List<WeiboTwo> weiboTwoList = jdbcTemplateTwo.query(sqlweibo2, new BeanPropertyRowMapper<>(WeiboTwo.class));

        // 查询第三个库中的leader表
        List<OpinionLeaderOne> opinionleaderOneList = jdbcTemplateThree.query(sqlleader1, new BeanPropertyRowMapper<>(OpinionLeaderOne.class));
        List<OpinionLeaderTwo> opinionleaderTwoList = jdbcTemplateThree.query(sqlleader2, new BeanPropertyRowMapper<>(OpinionLeaderTwo.class));
        List<OpinionLeaderThree> opinionleaderThreeList = jdbcTemplateThree.query(sqlleader3, new BeanPropertyRowMapper<>(OpinionLeaderThree.class));
        List<OpinionLeaderFour> opinionleaderFourList = jdbcTemplateThree.query(sqlleader4, new BeanPropertyRowMapper<>(OpinionLeaderFour.class));
        List<TrackingOne> trackingOneList = jdbcTemplateZheng.query(sqltrack1, new BeanPropertyRowMapper<>(TrackingOne.class));
        Map<String,Object>  map = new HashMap<String, Object>();
        map.put("EventOneList", eventOneList);
        map.put("EventTwoList", eventTwoList);
        map.put("WeiboOneList", weiboOneList);
        map.put("WeiboTwoList", weiboTwoList);
        map.put("OpinionLeaderTwoList", opinionleaderTwoList);
        map.put("OpinionLeaderFourList", opinionleaderFourList);
        //map.put("OpinionLeaderOneList", opinionleaderOneList);
        Map<String,Object> opinionleaderOneMap = new HashMap<>();
        if(opinionleaderOneList!=null&&opinionleaderOneList.size()>0) {
        	for(OpinionLeaderOne d : opinionleaderOneList) {
        		opinionleaderOneMap.put(d.getName(), d);
        	}
        }
        Map<String,Object> opinionleaderThreeMap = new HashMap<>();
        if(opinionleaderThreeList!=null&&opinionleaderThreeList.size()>0) {
            for(OpinionLeaderThree d : opinionleaderThreeList) {
                opinionleaderThreeMap.put(d.getName(), d);
            }
        }

        Map<String,Object> trackingOneMap = new HashMap<>();
        if(trackingOneList!=null&&trackingOneList.size()>0) {
            for(TrackingOne d : trackingOneList) {
                trackingOneMap.put(d.getParameter(), d);
            }
        }
        map.put("OpinionLeaderOneList", opinionleaderOneMap);
        map.put("OpinionLeaderThreeList", opinionleaderThreeMap);
        map.put("TrackingOneList", trackingOneMap);
       com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
       String string =  object.toJSONString(map);
        
        return string;
    }


    @RequestMapping("/getAllData")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public String getAllData() {
        // query all events
        String sqlAll = "select * from abstract";
        List<Abstract> allList = jdbcTemplateFour.query(sqlAll, new BeanPropertyRowMapper<>(Abstract.class));
        Map<String,Object>  map = new HashMap<String, Object>();
        map.put("allItems", allList);

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
        String string =  object.toJSONString(map);
        
        return string;
    }
    public String getColour(String description, String[] array, String[] colourList){
        for(int index = 0; index<array.length; index++){
            if (description.equals(array[index])){
                return colourList[index];
            }
        }
        return "";
    }
    @RequestMapping("/getDataById")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public String getIdData(@RequestParam("eventid") int eventid) {
        // query all events
        String sqlAll = "select * from abstract where event_id = " + eventid;
        String[] colourList = {"#F56C6C", "#E6A23C", "#409EFF", "#67C23A"};
        String[] fs = {"情感激烈", "情感激动", "情感波动", "情感平和"};
        String[] bs = {"引爆全网", "积极关注", "略显积极", "漠不关心"};
        String[] cs = {"负向认知", "认知消极", "认知积极", "正向认知"};
        String[] ss = {"传播迅猛", "传播迅速", "传播较快", "传播缓慢"};
        List<Abstract> allList = jdbcTemplateFive.query(sqlAll, new BeanPropertyRowMapper<>(Abstract.class));
        List<String> colour = new ArrayList<>();
        colour.add(getColour(allList.get(0).getFeeling_description(), fs, colourList));
        colour.add(getColour(allList.get(0).getBehaviour_description(), bs, colourList));
        colour.add(getColour(allList.get(0).getCognition_description(), cs, colourList));
        colour.add(getColour(allList.get(0).getSpread_description(), ss, colourList));
        Map<String,Object>  map = new HashMap<String, Object>();
        map.put("colour", colour);
        map.put("result", allList);

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
        String string =  object.toJSONString(map);

        return string;
    }

    @RequestMapping("/getTime")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public String getTimeData(@RequestParam("eventid") int eventid) {
        // query all events
        String sqlAll = "select * from statistics where event_id = " + eventid;
        List<Statistics> allList = jdbcTemplateSix.query(sqlAll, new BeanPropertyRowMapper<>(Statistics.class));
        Map<String,Object>  map = new HashMap<String, Object>();
        map.put("result", allList);

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
        String string =  object.toJSONString(map);
        
        return string;
    }

    @RequestMapping("/yqList")
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public String getYqList() {
        String sqlAll = "select * from eventlist" ;
        List<EventList> yqList = jdbcTemplateSix.query(sqlAll, new BeanPropertyRowMapper<>(EventList.class));
        Map<String,Object>  map = new HashMap<String, Object>();
        map.put("result", yqList);

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
        String string =  object.toJSONString(map);

        return string;
    }

    //    下方是北邮陈越鹏代码部分

    @RequestMapping("/getEventDataBefore")//
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public Map<String,Object> getEventDataBefore(@RequestParam("eventNum") String eventNum) {
        String sqltring1 = "select * FROM eventsData WHERE eventNum=\'"+eventNum+"\'";
        Map<String, Object> eventsdata = jdbcTemplateChen.queryForMap(sqltring1);
        String sqltring2 = "select * FROM beforedata WHERE eventNum=\'"+eventNum+"\'";
        Map<String, Object> beforedata = jdbcTemplateChen.queryForMap(sqltring2);
        Map<String,Object> res = new HashMap<>();
        res.put("eventdata",eventsdata);
        res.put("radarData",beforedata);

        return res;
    }

    @RequestMapping("/getEventDataAfter")//获取对比数据
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public Map<String,Object> getEventDataAfter(@RequestParam("eventNum") String eventNum) {
        String sqltring1 = "select * FROM beforedata WHERE eventNum=\'"+eventNum+"\'";
        Map<String, Object> eventsdata = jdbcTemplateChen.queryForMap(sqltring1);

        String sqltring2 = "select * FROM compare WHERE eventNum=\'"+eventNum+"\'";
        Map<String, Object> afterdata = jdbcTemplateChen.queryForMap(sqltring2);
        Map<String,Object> res = new HashMap<>();
        res.put("beforedata",eventsdata);
        res.put("afterData",afterdata);

        return res;
    }
    @RequestMapping("/getEvents")//获取事件列表
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<eventsData_2> getEvents() {
        String sqlAll = "select eventNum,eventName FROM eventsData";
        List<eventsData_2> allList = jdbcTemplateChen.query(sqlAll, new BeanPropertyRowMapper<>(eventsData_2.class));

        return allList;
    }




    @RequestMapping("/strategy")//获取策略信息
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<strategyData> strategy(@RequestParam("val") String val) {
        String sqltring = "select * FROM strategy WHERE strategy_type=\'"+val+"\'";
        List<strategyData> eventOneList = jdbcTemplateChen.query(sqltring, new BeanPropertyRowMapper<>(strategyData.class));
        return eventOneList;
    }

    @RequestMapping("/liwenliang")//获取所有李文亮数据帖子信息
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<liAllDatas> liwenliang(@RequestParam("page") int page) {

        String sqltring = "select * FROM lidatas_all limit "+page*30+",30";
        List<liAllDatas> eventOneList = jdbcTemplateChen.query(sqltring, new BeanPropertyRowMapper<>(liAllDatas.class));
        return eventOneList;
    }
    @RequestMapping("/selectSort")//按条件筛选李文亮帖子数据
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<liAllDatas> selectSort(@RequestParam("keyword") String keyword,@RequestParam("page") int page) {
        String sqltring = "select * FROM lidatas_all ORDER BY ABS("+keyword+") DESC limit "+page*30+",30";
        List<liAllDatas> eventOneList = jdbcTemplateChen.query(sqltring, new BeanPropertyRowMapper<>(liAllDatas.class));
        return eventOneList;

    }
    @RequestMapping("/selectTieziXiangqing")//获取某个帖子信息 这个接口的大小写是正常的
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public Map<String, Object> selectTieziXiangqing(@RequestParam("no") int no) {
        String sqltring = "select * FROM lidatas_all  WHERE no=\'"+no+"\'";
        Map<String, Object> eventOneList = jdbcTemplateChen.queryForMap(sqltring);
        return eventOneList;
    }
    //
    @RequestMapping("/strategyDetail")//获取某一策略具体信息
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<strategyData> strategyDetail(@RequestParam("val") String val) {

        String sqltring = "select * FROM strategy WHERE intervention_strategy=\'"+val+"\'";
        List<strategyData> eventOneList = jdbcTemplateChen.query(sqltring, new BeanPropertyRowMapper<>(strategyData.class));
        return eventOneList;

    }

    @RequestMapping("/getStrategyImg")//获取干预结果图像
    @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<InterventionPoint> getStrategyImg(@RequestParam("point") String point,@RequestParam("intensity") String intensity) {
        String sqltring = "select * FROM intervention_image WHERE Intervention_point=\'"+point+"\' and intensity=\'"+intensity+"\'";
        List<InterventionPoint> eventOneList = jdbcTemplateChen.query(sqltring, new BeanPropertyRowMapper<>(InterventionPoint.class));
        return eventOneList;
    }

//    上述是北邮陈越鹏代码

    // @RequestMapping("/getDataPart1")
    // @CrossOrigin(allowedHeaders = "*",origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    // public String showTablesDataPart1(@RequestParam("eventid") int eventid) {
    //     // 查询abstract表数据的sql
    //     String sqlevent1 = "select * from abstract where event_id = " + eventid;
    //     // 查询statistics表数据的sql
    //     String sqlevent2 = "select time, timesum from statistics where event_id = " + eventid;

        
    //     // 查询第一个库中的event表
    //     List<Abstract> AbstractList= jdbcTemplateFour.query(sqlevent1, new BeanPropertyRowMapper<>(Abstract.class));
    //     List<Statistics> StatisticsList= jdbcTemplateFour.query(sqlevent2, new BeanPropertyRowMapper<>(Statistics.class));
        
        
        
    //     Map<String,Object>  map = new HashMap<String, Object>();
    //     map.put("AbstractList", AbstractList);
    //     map.put("Statistics", StatisticsList);
        
        
    //    com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
    //    String string =  object.toJSONString(map);
        
    //    return string;
    // }
}
