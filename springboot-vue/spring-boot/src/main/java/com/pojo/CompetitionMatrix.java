package com.pojo;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

@Resource
public class CompetitionMatrix implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 时间窗口开始时间
     */
    private Date startdate;

    /**
     * 竞争矩阵原始值
     */
    private String rawMatrixValue;

    /**
     * 竞争矩阵归一化值
     */
    private String normMatrixValue;

    public CompetitionMatrix() {
    }

    public CompetitionMatrix(Integer id, Date startdate, String rawMatrixValue, String normMatrixValue) {
        this.id = id;
        this.startdate = startdate;
        this.rawMatrixValue = rawMatrixValue;
        this.normMatrixValue = normMatrixValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getRawMatrixValue() {
        return rawMatrixValue;
    }

    public void setRawMatrixValue(String rawMatrixValue) {
        this.rawMatrixValue = rawMatrixValue;
    }

    public String getNormMatrixValue() {
        return normMatrixValue;
    }

    public void setNormMatrixValue(String normMatrixValue) {
        this.normMatrixValue = normMatrixValue;
    }


    private static final long serialVersionUID = 1L;
}