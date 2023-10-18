package com.pojo;

import java.util.List;

public class MessageInfo {
    /**
     * @param mid               正文ID
     * @param probs             正文的分类概率，1 * 15
     * @param predict           正文的预测分类结果
     * @param typeLabel         正文的分类标签
     * @param truePop           正文的真实热度值
     */
    private String mid;
    private List<Double> probs;
    private Double predict;
    private String typeLabel;
    private Integer truePop;

    public MessageInfo() {
    }

    public MessageInfo(String mid, List<Double> probs, Double predict, String typeLabel, Integer truePop) {
        this.mid = mid;
        this.probs = probs;
        this.predict = predict;
        this.typeLabel = typeLabel;
        this.truePop = truePop;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public List<Double> getProbs() {
        return probs;
    }

    public void setProbs(List<Double> probs) {
        this.probs = probs;
    }

    public Double getPredict() {
        return predict;
    }

    public void setPredict(Double predict) {
        this.predict = predict;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public Integer getTruePop() {
        return truePop;
    }

    public void setTruePop(Integer truePop) {
        this.truePop = truePop;
    }
}
