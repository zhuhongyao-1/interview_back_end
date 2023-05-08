package com.zhy.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.interview.entity.Title;
import org.apache.ibatis.annotations.Mapper;



/**
 * (Title)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-01 17:52:50
 */
@Mapper
public interface TitleMapper extends BaseMapper<Title> {

}

