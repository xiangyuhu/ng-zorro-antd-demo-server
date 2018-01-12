package com.xinyuegu.star.knowledge.model;

import com.xinyuegu.star.common.utils.BeanConvertUtils;
import com.xinyuegu.star.knowledge.model.dto.ArticleOutDto;
import org.springframework.beans.BeanUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author coffice
 */
public class Article {
  private Integer id;
  private String title;
  private String content;
  private String classificationNo;
  private String sign;
  private Date createTime;
  private String author;
  private String original;
  private String state;
  private String icon;

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

  public String getContent() {
    return content;
  }

  public void setContent(String content){
    this.content = content;
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

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public  static List<ArticleOutDto> convertToDtoList (List<Article> list){
    ArticleOutDtoConvert articleOutDtoConvert = new ArticleOutDtoConvert();
    return articleOutDtoConvert.doForwardList(list);
  }

  public static class ArticleOutDtoConvert extends BeanConvertUtils<Article, ArticleOutDto> {
    @Override
    protected ArticleOutDto doForward(Article article) {
      ArticleOutDto articleOutDto = new ArticleOutDto();
      BeanUtils.copyProperties(article, articleOutDto);
      return articleOutDto;
    }

    @Override
    protected Article doBackward(ArticleOutDto articleOutDto) {
      throw new AssertionError();
    }

    @Override
    protected List<ArticleOutDto> doForwardList(List<Article> list) {
      List<ArticleOutDto> result = null;
      if (list != null && list.size() > 0) {
        result = new LinkedList<ArticleOutDto>();
        for (Article article : list) {
          ArticleOutDto articleOutDto = new ArticleOutDto();
          BeanUtils.copyProperties(article, articleOutDto);
          result.add(articleOutDto);
        }
      }
      return result;
    }

    @Override
    protected List<Article> doBackwardList(List<ArticleOutDto> list) {
      throw new AssertionError();
    }
  }
}
