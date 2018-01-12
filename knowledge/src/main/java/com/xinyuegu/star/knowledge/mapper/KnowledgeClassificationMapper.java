package com.xinyuegu.star.knowledge.mapper;

import com.xinyuegu.star.knowledge.model.KnowledgeClassification;

import java.util.List;
/**
 * @author hxy
 * @time 2018/1/4
 * @desc
 */
public interface KnowledgeClassificationMapper {
    List<KnowledgeClassification> selectPage();

    int insert(KnowledgeClassification knowledgeClassification);
}
