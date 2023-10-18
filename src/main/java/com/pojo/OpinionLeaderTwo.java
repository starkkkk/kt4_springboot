package com.pojo;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class OpinionLeaderTwo implements Serializable {
    private String user_name;
    private String num1;
    private String num2;
    private String num3;
    private List<Map<String,Object>> list1;
    private List<Map<String,Object>> list2;

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getNum1() {
        return num1;
    }
    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }
    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getNum3() {
        return num3;
    }
    public void setNum3(String num3) {
        this.num3 = num3;
    }
    public List<Map<String,Object>> getList1(){
        List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
        String[] list11=user_name.split(",");
        String[] list12=num1.split(",");
        for (int i = 0; i < list11.length; i++) {
            Map<String,Object> dict1 = new HashMap<>();
            dict1.put("tableprop",list12[i]);
            dict1.put("label", list11[i]);
            list1.add(dict1);
        }
        return list1;
    }
    public void setList1(List<Map<String,Object>> list1){
        this.list1=list1;
    }

    public List<Map<String,Object>> getList2() {
        String[] list13=num1.split(",");
        String[] list14=num2.split(",");
        String[] list15=num3.split(",");
        List<Map<String, Object>> list2 = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        for (int i = 0; i < list13.length; i++) {
            map1.put(list13[i], list14[i]);
        }
        list2.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        for (int i = 0; i < list13.length; i++) {
            map2.put(list13[i], list15[i]);
        }
        list2.add(map2);
        return list2;
    }
    public void setList2(List<Map<String,Object>> list2){
        this.list2=list2;
    }

    @Override
    public String toString() {
        return "OpinionLeaderTwo{" +
                "user_name=" + user_name +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", list1='" + list1 +
                ", list2='" + list2 +
                '}';
    }
}
