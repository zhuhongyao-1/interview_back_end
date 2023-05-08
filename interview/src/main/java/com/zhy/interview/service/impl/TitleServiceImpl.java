package com.zhy.interview.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.Title;
import com.zhy.interview.mapper.TitleMapper;
import com.zhy.interview.service.TitleService;
import com.zhy.interview.vo.QueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Title)表服务实现类
 *
 * @author makejava
 * @since 2023-05-01 17:52:51
 */
@Slf4j
@Service("titleService")
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements TitleService {

    @Override
    public List<Title> getTitle(String title) {
        return baseMapper.selectList(new QueryWrapper<Title>().eq("tag", title));
    }

    @Override
    public List<Title> getTitleListbyLike(String[] split, String questionType, Title title) {
        Map<Integer, Title> titleHashMap = new HashMap<>();


        for (String keyword : split) {
            log.info("keyword:{}", keyword);
            List<Title> titleList = baseMapper.selectList(new QueryWrapper<Title>().eq("question_type", questionType).like("title_name", keyword));
            titleList.forEach(item -> {

                Integer id = item.getId();
                if (!titleHashMap.containsKey(id)) {
                    titleHashMap.put(item.getId(), item);
                }
            });
        }

        List<Title> titles = new ArrayList<>();
        titleHashMap.forEach((key, value) -> {
            if (!key.equals(title.getId())) {
                titles.add(value);
            }
        });
        return titles;
    }

    @Override
    public List<Title> queryByCondition(QueryVo queryVo) {
        String questionType = queryVo.getQuestionType();
        String difficulty = queryVo.getDifficulty();
        String search = queryVo.getSearch();
        String tag = queryVo.getTag();
        List<Title> titleList = null;


        if (queryVo.getOrderType()!=null &&2==queryVo.getOrderType()) {
            titleList = baseMapper.selectList(new QueryWrapper<Title>().eq(StringUtils.hasText(questionType), "question_type", questionType)
                    .eq(StringUtils.hasText(difficulty), "difficulty", difficulty)
                    .like(StringUtils.hasText(search), "title_name", search)
                    .eq(StringUtils.hasText(tag), "tag", tag).orderByDesc("page_views"));
        } else if (queryVo.getOrderType()!=null&&3==queryVo.getOrderType()) {
            titleList = baseMapper.selectList(new QueryWrapper<Title>().eq(StringUtils.hasText(questionType), "question_type", questionType)
                    .eq(StringUtils.hasText(difficulty), "difficulty", difficulty)
                    .like(StringUtils.hasText(search), "title_name", search)
                    .eq(StringUtils.hasText(tag), "tag", tag).orderByDesc("collection_number"));
        } else {
            titleList = baseMapper.selectList(new QueryWrapper<Title>().eq(StringUtils.hasText(questionType), "question_type", questionType)
                    .eq(StringUtils.hasText(difficulty), "difficulty", difficulty)
                    .like(StringUtils.hasText(search), "title_name", search)
                    .eq(StringUtils.hasText(tag), "tag", tag).orderByDesc("create_time"));
        }
        return titleList;
    }
}

