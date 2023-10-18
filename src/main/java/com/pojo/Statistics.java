package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Statistics implements Serializable {
    private int event_id;
    private String time;
    private int timesum;

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTimesum() {
        return timesum;
    }

    public void setTimesum(int timesum) {
        this.timesum = timesum;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "event_id=" + event_id +
                ", time='" + time + '\'' +
                ", timesum=" + timesum +
                '}';
    }
}