package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class EventList implements Serializable{
    private int event_id;
    private String event_name;
    private String event_type;
    private int document_number;
    private String platform;
    //private float situation_score;
    private String situation_description;

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

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public int getDocument_number() {
        return document_number;
    }

    public void setDocument_number(int document_number) {
        this.document_number = document_number;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


    public String getSituation_description() {
        return situation_description;
    }

    public void setSituation_description(String situation_description) {
        this.situation_description = situation_description;
    }

    @Override
    public String toString() {
        return "EventList{" +
                "event_id=" + event_id +
                ", event_name='" + event_name + '\'' +
                ", event_type='" + event_type + '\'' +
                ", document_number=" + document_number +
                ", platform='" + platform + '\'' +
                ", situation_description='" + situation_description + '\'' +
                '}';
    }
}
