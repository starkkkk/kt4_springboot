package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class EventTwo implements Serializable {
    private Long id;
    private String content;
    private Long user_id;
//    @JsonFormat(locale="zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date announce_time;
    private LocalDateTime announce_time;
    private String url;

//    private Boolean authenticated_flag;
//    private int count;

    public EventTwo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getAnnounce_time() {
        return announce_time;
    }

    public void setAnnounce_time(LocalDateTime announce_time) {
        this.announce_time = announce_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EventTwo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", announce_time=" + announce_time +
                ", url='" + url + '\'' +
                '}';
    }
}