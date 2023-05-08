package com.zhy.interview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhy.interview.entity.Title;
import com.zhy.interview.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.mapper.UserMapper;
import com.zhy.interview.service.UserService;
import com.zhy.interview.vo.QueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-04-22 16:57:47
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {




}

