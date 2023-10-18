package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class WeiboOne implements Serializable {
    private Long id;
    private Long user_id;
    private Long interact_id;
    private Byte type;
    private int forward_num;
    private int comment_num;
    private String interact_content;
    private String original_content;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale="zh",timezone = "GMT+8")
//    private Date announce_time;
    private LocalDateTime announce_time;

    public WeiboOne() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getInteract_id() {
        return interact_id;
    }

    public void setInteract_id(Long interact_id) {
        this.interact_id = interact_id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public int getForward_num() {
        return forward_num;
    }

    public void setForward_num(int forward_num) {
        this.forward_num = forward_num;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public String getInteract_content() {
        return interact_content;
    }

    public void setInteract_content(String interact_content) {
        this.interact_content = interact_content;
    }

    public String getOriginal_content() {
        return original_content;
    }

    public void setOriginal_content(String original_content) {
        this.original_content = original_content;
    }

    public LocalDateTime getAnnounce_time() {
        return announce_time;
    }

    public void setAnnounce_time(LocalDateTime announce_time) {
        this.announce_time = announce_time;
    }

    @Override
    public String toString() {
        return "WeiboOne{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", interact_id=" + interact_id +
                ", type=" + type +
                ", forward_num=" + forward_num +
                ", comment_num=" + comment_num +
                ", interact_content='" + interact_content + '\'' +
                ", original_content='" + original_content + '\'' +
                ", announce_time=" + announce_time +
                '}';
    }
}
