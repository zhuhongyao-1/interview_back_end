package com.zhy.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhy.interview.entity.Title;
import com.zhy.interview.entity.User;
import com.zhy.interview.vo.QueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-04-22 16:58:16
 */

public interface UserService extends IService<User> {


    List<Title> seeValue(String userId);
}

