package com.zhy.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.interview.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-22 16:28:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

