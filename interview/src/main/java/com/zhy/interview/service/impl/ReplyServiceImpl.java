package com.zhy.interview.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.Reply;
import com.zhy.interview.service.ReplyService;
import com.zhy.interview.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

/**
 * (Reply)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 15:13:18
 */
@Service("replyService")
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {

}

