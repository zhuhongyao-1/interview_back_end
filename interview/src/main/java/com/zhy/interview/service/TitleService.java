package com.zhy.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhy.interview.entity.Title;
import com.zhy.interview.vo.QueryVo;

import java.util.List;


/**
 * (Title)表服务接口
 *
 * @author makejava
 * @since 2023-05-01 17:52:50
 */
public interface TitleService extends IService<Title> {

    List<Title> getTitle(String title);

    List<Title> getTitleListbyLike(String[] split,String questionType,Title title);

    List<Title> queryByCondition(QueryVo queryVo);
}

