package com.pojo;

import cn.hutool.core.lang.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class TrackingOne {
    private String parameter;
    private String accuracy;
    private String similarity;
    private String user_name;
    private String top;
    private String num1;
    private String num2;
    private String[] list1;
    private String[] list2;
    private String[] list3;
    private String[] list4;
    private String[] list5;
    private String[] list6;
    private List<Map<String,Object>> list7;
    private List<Map<String,Object>> list8;
    private List<Map<String,Object>> list9;
    private List<Map<String,Object>> list10;

    public String getParameter() {
        return parameter;
    }
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getSimilarity() {
        return similarity;
    }
    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getTop() {
        return top;
    }
    public void setTop(String top) {
        this.top = top;
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
    public String[] getList1(){
        String[] list1=accuracy.split(",");
//        String list2=String.join("!!!!", list);
        return list1;
    }
    public void setList1(String[] list1){
        this.list1=list1;
    }

    public String[] getList2(){
        String[] list2=similarity.split(",");
        return list2;
    }
    public void setList2(String[] list2){
        this.list2=list2;
    }
    List<String> languages = new ArrayList<>();
    public String[] getList3(){
        String[] list3=user_name.split(",");
        return list3;
    }
    public void setList3(String[] list3){
        this.list3=list3;
    }
    public String[] getList4(){
        String[] list4=top.split(",");
        return list4;
    }
    public void setList4(String[] list4){
        this.list4=list4;
    }
    public String[] getList5(){
        String[] list5=num1.split(",");
        return list5;
    }
    public void setList5(String[] list5){
        this.list5=list5;
    }
    public String[] getList6(){
        String[] list6=num2.split(",");
        return list6;
    }
    public void setList6(String[] list6){
        this.list6=list6;
    }

    public List<Map<String,Object>> getList7(){
        List<Map<String,Object>> list7 = new ArrayList<Map<String,Object>>();
        Map<String,Object> dict1 = new HashMap<>();
        dict1.put("tableprop","a1");
        dict1.put("label", "用户名");
        Map<String,Object> dict2 = new HashMap<>();
        dict2.put("tableprop","a2");
        dict2.put("label", "相似度");
        list7.add(dict1);
        list7.add(dict2);
        return list7;
    }
    public void setList7(List<Map<String,Object>> list7){
        this.list7=list7;
    }

    public List<Map<String,Object>> getList8() {
        String[] list30=user_name.split(",");
        String[] list31=similarity.split(",");
        List<Map<String, Object>> list8 = new ArrayList<>();
        for (int i = 0; i < list30.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("a1", list30[i]);
            map.put("a2", list31[i]);
            list8.add(map);

        }
        return list8;
    }
    public void setList8(List<Map<String,Object>> list8){
        this.list8=list8;
    }
    public List<Map<String,Object>> getList9() {
        List<Map<String,Object>> list9 = new ArrayList<Map<String,Object>>();
        Map<String,Object> dict1 = new HashMap<>();
        dict1.put("tableprop","b1");
        dict1.put("label", "top-k");
        Map<String,Object> dict2 = new HashMap<>();
        dict2.put("tableprop","b2");
        dict2.put("label", "precision");
        list9.add(dict1);
        list9.add(dict2);
        return list9;
    }
    public void setList9(List<Map<String,Object>> list9){
        this.list9=list9;
    }
    public List<Map<String,Object>> getList10(){
        String[] list32=top.split(",");
        String[] list33=accuracy.split(",");
        List<Map<String, Object>> list10 = new ArrayList<>();
        for (int i = 0; i < list32.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("b1", list32[i]);
            map.put("b2", list33[i]);
            list10.add(map);
        }
        return list10;
    }
    public void setList10(List<Map<String,Object>> list10){
        this.list10=list10;
    }
//        Map<String,Object> dict3 = new HashMap<>();
//        String[] list20={"1","3","3"};
//        System.out.println("list30="+list30.length);
//        for (int i = 0; i <list30.length; i++) {
//            System.out.println("list30="+list30[i]);
//        }
//        System.out.println("list5="+list5.length);
//        System.out.println("list3="+list3.length);
//
//        for (int i = 0; i <list5.length; i++) {
//            System.out.println("list5="+list5[i]);
//        }
//        for (int i = 0; i <list3.length; i++) {
//            System.out.println("list3="+list3[i]);
//        }
//
//        for(int i=0;i<list20.length;i++){
//            dict3.put(list5[1], list3[1]);
//            list8.add(dict3);
//        }
@Override
public String toString() {
    return "TrackingOne{" +
            "parameter=" + parameter +
            ", accuracy=" + accuracy +
            ", similarity=" + similarity +
            ", list1=" + list1 +
            ", list2=" + list2 +
            ", list3=" + list3 +
            ", list4=" + list4 +
            ", list5=" + list5 +
            ", list6=" + list6 +
            ", list7=" + list7 +
            ", list8=" + list8+
            ", list9=" + list9+
            ", list10=" + list10+
    '}';
}
}


