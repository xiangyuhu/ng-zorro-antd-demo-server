package com.xinyuegu.star.knowledge.service.impl;

import com.xinyuegu.star.knowledge.mapper.ArticleMapper;
import com.xinyuegu.star.knowledge.model.Article;
import com.xinyuegu.star.knowledge.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxy
 * @time 2018/1/6
 * @desc
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Resource
    ArticleMapper articleMapper;
    @Override
    public int insert(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public List<Article> select() {
        return articleMapper.select();
    }

    @Override
    public Article selectById(int articleId) {
        return articleMapper.selectById(articleId);
    }

    @Override
    public int update(Article article) {
        return articleMapper.update(article);
    }
}
