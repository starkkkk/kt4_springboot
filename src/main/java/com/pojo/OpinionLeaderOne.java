package com.pojo;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class OpinionLeaderOne implements Serializable {
    private String user_id;
    private Long id;
    private String name;
    private String event;
    private Long fans;
    private Long share;
    private Long comments;
    private String report;
    private String type;
    private double lh_index;
    private int rank1;
    private double between;
    private int rank2;
    private double behavior;
    private int rank3;
    private double topic;
    private int rank4;
    private double tops;
    private int rank5;
    private String[] list1;
    private String[] list2;
    private Map<String,Object> dict1;

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }

    public Long getFans() {
        return fans;
    }
    public void setFans(Long fans) {
        this.fans = fans;
    }

    public Long getShare() {
        return share;
    }
    public void setShare(Long share) {
        this.share = share;
    }

    public Long getComments() {
        return comments;
    }
    public void setComments(Long comments) {
        this.comments = comments;
    }

    public String getReport() {
        return report;
    }
    public void setReport(String report) {
        this.report = report;
    }

    public String getType() {
        return type;

    }
    public void setType(String type) {
        this.type = type;
    }

    public double getLh_index() {
        return lh_index;
    }
    public void setLh_index(double lh_index) {
        this.lh_index = lh_index;
    }

    public int getRank1() {
        return rank1;
    }
    public void setRank1(int rank1) {
        this.rank1 = rank1;
    }

    public double getBetween() {
        return between;
    }
    public void setBetween(double between) {
        this.between = between;
    }

    public int getRank2() {
        return rank2;
    }
    public void setRank2(int rank2) {
        this.rank2 = rank2;
    }

    public double getBehavior() {
        return behavior;
    }
    public void setBehavior(double behavior) {
        this.behavior = behavior;
    }

    public int getRank3() {
        return rank3;
    }
    public void setRank3(int rank3) {
        this.rank3 = rank3;
    }

    public double getTopic() {
        return topic;
    }
    public void setTopic(double topic) {
        this.topic = topic;
    }

    public int getRank4() {
        return rank4;
    }
    public void setRank4(int rank4) {
        this.rank4 = rank4;
    }

    public double getTops() {
        return tops;
    }
    public void setTops(double tops) {
        this.tops = tops;
    }

    public int getRank5() {
        return rank5;
    }
    public void setRank5(int rank5) {
        this.rank5 = rank5;
//        System.out.println(rank5);
    }
    public String[] getList1(){
        String[] list1=report.split("\n");
//        String list2=String.join("!!!!", list);
        return list1;
    }
    public void setList1(String[] list1){
        this.list1=list1;
    }

    public String[] getList2(){
        String[] list2=type.split("，");
        return list2;
    }
    public void setList2(String[] list2){
        this.list2=list2;
    }

    public Map<String,Object> getDict1(){
        List<String> dict_list1 = new ArrayList<String>();
        dict_list1.add("LH-index");
        dict_list1.add("介数中心性");
        dict_list1.add("用户行为影响力");
        dict_list1.add("用户话题影响力");
        dict_list1.add("综合评估影响力");
        List<Double> dict_list2 = new ArrayList<Double>();
        dict_list2.add(lh_index);
        dict_list2.add(between);
        dict_list2.add(behavior);
        dict_list2.add(topic);
        dict_list2.add(tops);
        List<Integer> dict_list3 = new ArrayList<Integer>();
        dict_list3.add(rank1);
        dict_list3.add(rank2);
        dict_list3.add(rank3);
        dict_list3.add(rank4);
        dict_list3.add(rank5);
        Map<String,Object> dict2 = new HashMap<>();
        dict2.put("算法名称", dict_list1);
        dict2.put("用户影响力", dict_list2);
        dict2.put("影响力在所有用户中的排名", dict_list3);
        Map<String,Object>dict1=dict2;
        return dict1;
    }
    public void setDict1(Map<String,Object> dict1){
        this.dict1=dict1;
    }


    @Override
    public String toString() {
        return "OpinionLeaderOne{" +
                "user_id=" + user_id + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", event='" + event + '\'' +
                ", type=" + type +
                ", fans=" + fans +
                ", share=" + share +
                ", comments=" + comments +
                ", list1='" + list1 +
                ", list2='" + list2 +
                ", dict1='" + dict1 +
                ", type='" + type + '\'' +
                ", lh_index=" + lh_index +
                ", rank1=" + rank1 +
                ", between=" + between+
                ", rank2=" + rank2 +
                ", behavior=" + behavior +
                ", rank3=" + rank3 +
                ", topic=" + topic +
                ", rank4=" + rank4 +
                ", tops=" + tops +
                ", rank5=" + rank5 +
                '}';
    }
}