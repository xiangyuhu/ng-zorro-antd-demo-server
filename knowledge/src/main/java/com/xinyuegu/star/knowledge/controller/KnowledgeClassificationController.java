package com.xinyuegu.star.knowledge.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.xinyuegu.star.common.dto.JSONResult;
import com.xinyuegu.star.common.dto.PageInfoDto;
import com.xinyuegu.star.knowledge.model.KnowledgeClassification;
import com.xinyuegu.star.knowledge.service.KnowledgeClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxy
 * @time 2018/1/4
 * @desc
 */
@RestController
@RequestMapping("/knowledgeClassification")
public class KnowledgeClassificationController {

    private static final Logger logger = LoggerFactory.getLogger(KnowledgeClassificationController.class);

    @Resource
    KnowledgeClassificationService knowledgeClassificationService;

    @GetMapping(value = "/page/{pageSize}/{pageNum}")
    public JSONResult<PageInfoDto<KnowledgeClassification>> page(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum){

        JSONResult<PageInfoDto<KnowledgeClassification>> result = new JSONResult<PageInfoDto<KnowledgeClassification>>(null, "", false);
        PageInfoDto<KnowledgeClassification> pageResult = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<KnowledgeClassification> list = knowledgeClassificationService.selectPage();
            Page page = (Page)list;
            pageResult = new PageInfoDto(page.getResult(), page.getTotal());
            result.setData(pageResult);
            result.setMessage("查询成功");
            result.setStatusCode(200);
        } catch (Exception e){
            logger.error("获取分类异常：", e);
        }
        return result;
    }

    @GetMapping(value = "/select")
    JSONResult<List<KnowledgeClassification>> select() {
        JSONResult<List<KnowledgeClassification>> result = new JSONResult<List<KnowledgeClassification>>();
        result.setSuccess(false);
        try {
            List<KnowledgeClassification> list =  knowledgeClassificationService.selectPage();
            result.setData(list);
            result.setSuccess(true);
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setMessage("查询异常");
            logger.error("查询异常：", e);
        }
        return result;
    }

    @PostMapping(value = "/insert")
    JSONResult<Integer> insert(@RequestBody KnowledgeClassification knowledgeClassification) {
        JSONResult<Integer> result = new JSONResult<Integer>();
        result.setSuccess(false);
        try {
            knowledgeClassificationService.insert(knowledgeClassification);
            result.setSuccess(true);
            result.setMessage("添加信息成功");
        } catch (Exception e) {
            result.setMessage("分类信息添加异常");
            logger.error("分类信息添加异常异常：", e);
        }
        return result;
    }

}
