package com.xinyuegu.star.knowledge.service;

import com.xinyuegu.star.knowledge.model.Article;

import java.util.List;

/**
 * @author hxy
 * @time 2018/1/6
 * @desc
 */
public interface ArticleService {
    int insert(Article article);
    List<Article> select();

    Article selectById(int articleId);

    int update(Article article);
}
