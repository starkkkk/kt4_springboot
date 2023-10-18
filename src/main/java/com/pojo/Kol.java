package com.pojo;

import java.io.Serializable;
import java.util.Date;

public class Kol implements Serializable {
    /**
    * 自增ID
    */
    private Integer id;

    /**
    * 用户唯一UID
    */
    private Long uid;

    /**
    * 用户昵称
    */
    private String nickname;

    /**
    * 微博数量
    */
    private Integer postnum;

    /**
    * 关注人数
    */
    private Integer followingnum;

    /**
    * 粉丝人数
    */
    private Integer fansnum;

    /**
    * 用户住址
    */
    private String address;

    /**
    * 性别
    */
    private String gender;

    /**
    * 生日
    */
    private Date birthday;

    /**
    * 微博注册日期
    */
    private Date registrationtime;

    /**
    * 描述，即用户简介
    */
    private String description;

    /**
    * 用户标签，即微博下方短签名
    */
    private String tags;

    /**
    * 评论总数
    */
    private Long commentsum;

    /**
    * 转发总数
    */
    private Long repostsum;

    /**
    * 影响力
    */
    private Double influence;

    /**
    * 强连接粉丝数
    */
    private Integer strongtiefansnum;

    /**
    * 用户来源
    */
    private String source;

    /**
    * 用户主要行为
    */
    private String userdeeds;

    /**
    * 用户主要发布内容
    */
    private String usercontentsummary;

    /**
    * 意见领袖领域
    */
    private String koldomain;


    /**
     * 意见领袖经过测试机构判定，是否正确
     */
    private Integer ifCorrect;

    private static final long serialVersionUID = 1L;

    public Kol() {
    }

    public Kol(Integer id, Long uid, String nickname, Integer postnum, Integer followingnum, Integer fansnum, String address, String gender, Date birthday, Date registrationtime, String description, String tags, Long commentsum, Long repostsum, Double influence, Integer strongtiefansnum, String source, String userdeeds, String usercontentsummary, String koldomain, Integer ifCorrect) {
        this.id = id;
        this.uid = uid;
        this.nickname = nickname;
        this.postnum = postnum;
        this.followingnum = followingnum;
        this.fansnum = fansnum;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.registrationtime = registrationtime;
        this.description = description;
        this.tags = tags;
        this.commentsum = commentsum;
        this.repostsum = repostsum;
        this.influence = influence;
        this.strongtiefansnum = strongtiefansnum;
        this.source = source;
        this.userdeeds = userdeeds;
        this.usercontentsummary = usercontentsummary;
        this.koldomain = koldomain;
        this.ifCorrect = ifCorrect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPostnum() {
        return postnum;
    }

    public void setPostnum(Integer postnum) {
        this.postnum = postnum;
    }

    public Integer getFollowingnum() {
        return followingnum;
    }

    public void setFollowingnum(Integer followingnum) {
        this.followingnum = followingnum;
    }

    public Integer getFansnum() {
        return fansnum;
    }

    public void setFansnum(Integer fansnum) {
        this.fansnum = fansnum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getCommentsum() {
        return commentsum;
    }

    public void setCommentsum(Long commentsum) {
        this.commentsum = commentsum;
    }

    public Long getRepostsum() {
        return repostsum;
    }

    public void setRepostsum(Long repostsum) {
        this.repostsum = repostsum;
    }

    public Double getInfluence() {
        return influence;
    }

    public void setInfluence(Double influence) {
        this.influence = influence;
    }

    public Integer getStrongtiefansnum() {
        return strongtiefansnum;
    }

    public void setStrongtiefansnum(Integer strongtiefansnum) {
        this.strongtiefansnum = strongtiefansnum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserdeeds() {
        return userdeeds;
    }

    public void setUserdeeds(String userdeeds) {
        this.userdeeds = userdeeds;
    }

    public String getUsercontentsummary() {
        return usercontentsummary;
    }

    public void setUsercontentsummary(String usercontentsummary) {
        this.usercontentsummary = usercontentsummary;
    }

    public String getKoldomain() {
        return koldomain;
    }

    public void setKoldomain(String koldomain) {
        this.koldomain = koldomain;
    }

    public Integer getIfCorrect() {
        return ifCorrect;
    }

    public void setIfCorrect(Integer ifCorrect) {
        this.ifCorrect = ifCorrect;
    }
}