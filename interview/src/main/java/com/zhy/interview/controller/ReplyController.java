package com.zhy.interview.controller;

import cn.hutool.core.date.DateUtil;
import com.zhy.interview.entity.Reply;
import com.zhy.interview.service.ReplyService;
import com.zhy.interview.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date: 2023/5/7 15:51
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;

    @RequestMapping("/reply")
    public R reply( @RequestBody Reply reply){
        log.info("reply:{}",reply);
        reply.setReplyTime(DateUtil.date());
        replyService.save(reply);
        return R.ok();
    }
}
