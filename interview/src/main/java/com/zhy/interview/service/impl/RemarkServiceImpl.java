package com.zhy.interview.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.Remark;
import com.zhy.interview.entity.Reply;
import com.zhy.interview.entity.User;
import com.zhy.interview.mapper.RemarkMapper;
import com.zhy.interview.mapper.ReplyMapper;
import com.zhy.interview.mapper.UserMapper;
import com.zhy.interview.service.UserService;
import com.zhy.interview.vo.RemarkVo;
import com.zhy.interview.vo.ReplyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.zhy.interview.service.RemarkService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Remark)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 11:58:06
 */
@Service("remarkService")
public class RemarkServiceImpl extends ServiceImpl<RemarkMapper, Remark> implements RemarkService {
     @Resource
     private UserMapper userMapper;

     @Resource
     private ReplyMapper replyMapper;

    @Override
    public List<RemarkVo> getRemark(String titleId,String orderType) {
        List<Remark> remarkList =null;
        if("hot".equals(orderType)){
            remarkList= baseMapper.selectList(new QueryWrapper<Remark>().eq("title_id", titleId).orderByDesc("thumbs"));
        }else {
            remarkList= baseMapper.selectList(new QueryWrapper<Remark>().eq("title_id", titleId).orderByDesc("comment_time"));
        }
        return remarkList.stream().map(item -> {
            RemarkVo remarkVo = new RemarkVo();
            BeanUtils.copyProperties(item, remarkVo);
            User user = userMapper.selectById(item.getUserId());
            remarkVo.setHeadPortrait(user.getHeadUrl());
            List<Reply> replies = replyMapper.selectList(new QueryWrapper<Reply>().eq("remark_id", item.getId()));
            List<ReplyVo> replyVoList = replies.stream().map(a -> {
                ReplyVo replyVo = new ReplyVo();
                BeanUtils.copyProperties(a, replyVo);
                replyVo.setUsername(user.getUsername());
                replyVo.setHeadPortrait(user.getHeadUrl());
                return replyVo;
            }).collect(Collectors.toList());
            remarkVo.setReplyVos(replyVoList);
            return remarkVo;
        }).collect(Collectors.toList());
    }
}

