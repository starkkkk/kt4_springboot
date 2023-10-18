package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 内容生成
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 事件类型，包含三类，分别是：经济类_event11，社会类_event07，政治类_event08
     */
    private String domain;

    /**
     * 具体的事件名称
     */
    private String event;

    /**
     * 一级标签
     */
    private String tagl1;

    /**
     * 二级标签
     */
    private String tagl2;

    /**
     * 三级标签
     */
    private String tagl3;

    /**
     * 四级标签
     */
    private String tagl4;

    /**
     * 具体语料内容
     */
    private String review;

    private static final long serialVersionUID = 1L;
}