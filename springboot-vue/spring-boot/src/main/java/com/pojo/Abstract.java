package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Abstract implements Serializable{
    private int event_id;
    private String event_name;
    private float feeling_score;
    private String feeling_description;
    private float spread_score;
    private String spread_description;
    private float cognition_score;
    private String cognition_description;
    private float behaviour_score;
    private String behaviour_description;
    private float situation_score;
    private String situation_description;
    private String location;
    private String word_frequency;
    private String all_word;
    private int document_number;
    private String event_type;
    private String platform;
    private String popular_weibo;
    private String sender_name;
    private String start_time;
    private String technology_guidance;
    private String psychological_guidance;
    private String attention_score;
    private String harm_score;


//    @JsonFormat(locale="zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date announce_time;

//    private Boolean authenticated_flag;
//    private int count;


    public String getAttention_score() {
        return attention_score;
    }

    public void setAttention_score(String attention_score) {
        this.attention_score = attention_score;
    }

    public String getHarm_score() {
        return harm_score;
    }

    public void setHarm_score(String harm_score) {
        this.harm_score = harm_score;
    }

    public String getTechnology_guidance() {
        return technology_guidance;
    }

    public void setTechnology_guidance(String technology_guidance) {
        this.technology_guidance = technology_guidance;
    }

    public String getPsychological_guidance() {
        return psychological_guidance;
    }

    public void setPsychological_guidance(String psychological_guidance) {
        this.psychological_guidance = psychological_guidance;
    }

    public String getPopular_weibo() {
        return popular_weibo;
    }

    public void setPopular_weibo(String popular_weibo) {
        this.popular_weibo = popular_weibo;
    }


    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public float getFeeling_score() {
        return feeling_score;
    }

    public void setFeeling_score(float feeling_score) {
        this.feeling_score = feeling_score;
    }

    public String getFeeling_description() {
        return feeling_description;
    }

    public void setFeeling_description(String feeling_description) {
        this.feeling_description = feeling_description;
    }

    public float getSpread_score() {
        return spread_score;
    }

    public void setSpread_score(float spread_score) {
        this.spread_score = spread_score;
    }

    public String getSpread_description() {
        return spread_description;
    }

    public void setSpread_description(String spread_description) {
        this.spread_description = spread_description;
    }

    public float getCognition_score() {
        return cognition_score;
    }

    public void setCognition_score(float cognition_score) {
        this.cognition_score = cognition_score;
    }

    public String getCognition_description() {
        return cognition_description;
    }

    public void setCognition_description(String cognition_description) {
        this.cognition_description = cognition_description;
    }

    public float getBehaviour_score() {
        return behaviour_score;
    }

    public void setBehaviour_score(float behaviour_score) {
        this.behaviour_score = behaviour_score;
    }

    public String getBehaviour_description() {
        return behaviour_description;
    }

    public void setBehaviour_description(String behaviour_description) {
        this.behaviour_description = behaviour_description;
    }

    public float getSituation_score() {
        return situation_score;
    }

    public void setSituation_score(float situation_score) {
        this.situation_score = situation_score;
    }

    public String getSituation_description() {
        return situation_description;
    }

    public void setSituation_description(String situation_description) {
        this.situation_description = situation_description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWord_frequency() {
        return word_frequency;
    }

    public void setWord_frequency(String word_frequency) {
        this.word_frequency = word_frequency;
    }

    public String getAll_word() {
        return all_word;
    }

    public void setAll_word(String all_word) {
        this.all_word = all_word;
    }

    public int getDocument_number() {
        return document_number;
    }

    public void setDocument_number(int number) {
        this.document_number = number;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "Abstract{" +
                "event_id=" + event_id +
                ", event_name='" + event_name + '\'' +
                ", feeling_score=" + feeling_score +
                ", feeling_description='" + feeling_description + '\'' +
                ", spread_score=" + spread_score +
                ", spread_description='" + spread_description + '\'' +
                ", cognition_score=" + cognition_score +
                ", cognition_description='" + cognition_description + '\'' +
                ", behaviour_score=" + behaviour_score +
                ", behaviour_description='" + behaviour_description + '\'' +
                ", situation_score=" + situation_score +
                ", situation_description='" + situation_description + '\'' +
                ", location='" + location + '\'' +
                ", word_frequency='" + word_frequency + '\'' +
                ", all_word='" + all_word + '\'' +
                ", document_number=" + document_number +
                ", event_type='" + event_type + '\'' +
                ", platform='" + platform + '\'' +
                ", popular_weibo='" + popular_weibo + '\'' +
                '}';
    }
}
