package com.pojo;

import java.io.Serializable;

/**
 * weibo_origin
 * @author  xlwu
 */
public class WeiboOrigin implements Serializable {
    /**
     * hbase rowkey
     */
    private String rowkey;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 推文id
     */
    private String id;

    /**
     * 发布推文的时间戳（毫秒）
     */
    private String posttime;

    /**
     * 点赞数
     */
    private String likenum;

    /**
     * 转发数
     */
    private String repostnum;

    /**
     * 评论数
     */
    private String commentnum;

    /**
     * 类别
     */
    private String type;

    /**
     * 类别概率
     */
    private String prob;

    /**
     * 内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public WeiboOrigin() {
    }

    public WeiboOrigin(String rowkey, String uid, String nickname, String id, String posttime, String likenum, String repostnum, String commentnum, String type, String prob, String content) {
        this.rowkey = rowkey;
        this.uid = uid;
        this.nickname = nickname;
        this.id = id;
        this.posttime = posttime;
        this.likenum = likenum;
        this.repostnum = repostnum;
        this.commentnum = commentnum;
        this.type = type;
        this.prob = prob;
        this.content = content;
    }

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public String getLikenum() {
        return likenum;
    }

    public void setLikenum(String likenum) {
        this.likenum = likenum;
    }

    public String getRepostnum() {
        return repostnum;
    }

    public void setRepostnum(String repostnum) {
        this.repostnum = repostnum;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProb() {
        return prob;
    }

    public void setProb(String prob) {
        this.prob = prob;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
