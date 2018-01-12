package com.xinyuegu.star.knowledge.model.dto;

import java.util.Date;

/**
 * @author hxy
 * @time 2018/1/8
 * @desc
 */
public class ArticleOutDto {
    private Integer id;
    private String title;
    private String classificationNo;
    private String sign;
    private Date createTime;
    private String author;
    private String original;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassificationNo() {
        return classificationNo;
    }

    public void setClassificationNo(String classificationNo) {
        this.classificationNo = classificationNo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
