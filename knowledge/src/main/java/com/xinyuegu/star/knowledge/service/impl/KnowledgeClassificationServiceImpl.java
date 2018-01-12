package com.xinyuegu.star.knowledge.service.impl;

import com.xinyuegu.star.knowledge.mapper.KnowledgeClassificationMapper;
import com.xinyuegu.star.knowledge.model.KnowledgeClassification;
import com.xinyuegu.star.knowledge.service.KnowledgeClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxy
 * @time 2018/1/4
 * @desc
 */
@Service
public class KnowledgeClassificationServiceImpl implements KnowledgeClassificationService {

    @Resource
    KnowledgeClassificationMapper knowledgeClassificationMapper;

    @Override
    public List<KnowledgeClassification> selectPage() {
        return knowledgeClassificationMapper.selectPage();
    }

    @Override
    public int insert(KnowledgeClassification knowledgeClassification) {
        return knowledgeClassificationMapper.insert(knowledgeClassification);
    }
}
