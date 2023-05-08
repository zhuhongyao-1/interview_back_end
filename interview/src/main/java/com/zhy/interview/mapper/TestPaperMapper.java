package com.zhy.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.interview.entity.TestPaper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
/**
 * (Tespaper)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-07 21:23:59
 */
public interface TestPaperMapper extends BaseMapper<TestPaper> {

}

