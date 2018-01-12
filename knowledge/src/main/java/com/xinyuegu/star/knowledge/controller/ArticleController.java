package com.xinyuegu.star.knowledge.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinyuegu.star.common.dto.JSONResult;
import com.xinyuegu.star.common.dto.PageInfoDto;
import com.xinyuegu.star.common.utils.BeanConvertUtils;
import com.xinyuegu.star.knowledge.model.Article;
import com.xinyuegu.star.knowledge.model.KnowledgeClassification;
import com.xinyuegu.star.knowledge.model.dto.ArticleOutDto;
import com.xinyuegu.star.knowledge.service.ArticleService;
import com.yingtang.uanfun.app.dto.NewsOutDto;
import com.yingtang.uanfun.common.model.News;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hxy
 * @time 2018/1/6
 * @desc
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    ArticleService articleService;

    @GetMapping(value = "/page/{pageSize}/{pageNum}")
    public JSONResult<PageInfoDto<ArticleOutDto>> page(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum){

        JSONResult<PageInfoDto<ArticleOutDto>> result = new JSONResult<PageInfoDto<ArticleOutDto>>(null, "", false);
        PageInfoDto<ArticleOutDto> pageResult = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Article> list = articleService.select();
            Page page = (Page)list;
            pageResult = new PageInfoDto(Article.convertToDtoList(page.getResult()), page.getTotal());
            result.setData(pageResult);
            result.setMessage("查询成功");
            result.setStatusCode(200);
        } catch (Exception e){
            result.setStatusCode(500);
            result.setMessage("系统异常");
            logger.error("获取文章page异常：", e);
        }
        return result;
    }

    @GetMapping(value = "/detail/{articleId}")
    public JSONResult<Article> detail(@PathVariable("articleId") int articleId){

        JSONResult<Article> result = new JSONResult<Article>(null, "", false);
        try {

            Article article = articleService.selectById(articleId);
            byte[] decodeBase64 = Base64.decodeBase64(article.getContent().getBytes("UTF-8"));
            article.setContent(new String(decodeBase64));
            result.setData(article);
            result.setMessage("查询成功");
            result.setStatusCode(200);
        } catch (Exception e){
            result.setStatusCode(500);
            result.setMessage("系统异常");
            logger.error("获取文章信息异常：", e);
        }
        return result;
    }

    @PostMapping(value = "/insert")
    JSONResult<Integer> insert(@RequestBody Article article) {
        JSONResult<Integer> result = new JSONResult<Integer>();
        result.setSuccess(false);
        try {
            byte[] encodeBase64 = Base64.encodeBase64(article.getContent().getBytes("UTF-8"));
            article.setContent(new String(encodeBase64));

            article.setCreateTime(new Date());
            articleService.insert(article);
            result.setSuccess(true);
            result.setMessage("文章发布成功");
        } catch (Exception e) {
            result.setMessage("文章发布异常");
            logger.error("文章发布异常：", e);
        }
        return result;
    }


    @PostMapping(value = "/update")
    JSONResult<Integer> update(@RequestBody Article article) {
        JSONResult<Integer> result = new JSONResult<Integer>();
        result.setSuccess(false);
        try {
            byte[] encodeBase64 = Base64.encodeBase64(article.getContent().getBytes("UTF-8"));
            article.setContent(new String(encodeBase64));
            articleService.update(article);
            result.setSuccess(true);
            result.setMessage("文章更新成功");
        } catch (Exception e) {
            result.setMessage("文章更新异常");
            logger.error("文章更新异常：", e);
        }
        return result;
    }
}
