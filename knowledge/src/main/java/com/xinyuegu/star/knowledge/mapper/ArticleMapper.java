package com.xinyuegu.star.knowledge.mapper;

import com.xinyuegu.star.knowledge.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hxy
 * @time 2018/1/6
 * @desc
 */
public interface ArticleMapper {
    public int insert(Article article);

    List<Article> select();

    Article selectById(@Param("articleId") int articleId);

    int update(Article article);
}
