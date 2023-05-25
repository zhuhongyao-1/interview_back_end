package com.zhy.interview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhy.interview.entity.Title;
import com.zhy.interview.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.ViewRecord;
import com.zhy.interview.mapper.TitleMapper;
import com.zhy.interview.mapper.UserMapper;
import com.zhy.interview.mapper.ViewRecordMapper;
import com.zhy.interview.service.TitleService;
import com.zhy.interview.service.UserService;
import com.zhy.interview.service.ViewRecordService;
import com.zhy.interview.vo.QueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-04-22 16:57:47
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private ViewRecordMapper viewRecordMapper;

    @Resource
    private TitleMapper titleMapper;

    @Override
    public List<Title> seeValue(String userId) {
        List<ViewRecord> viewRecordList = viewRecordMapper.selectList(new QueryWrapper<ViewRecord>().eq("user_id", userId));
        List<Integer> titleIdList = viewRecordList.stream().map(ViewRecord::getTitleId).collect(Collectors.toList());

        return titleMapper.selectBatchIds(titleIdList);
    }
}

