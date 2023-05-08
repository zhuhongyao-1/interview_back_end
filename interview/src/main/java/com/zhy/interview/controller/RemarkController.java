package com.zhy.interview.controller;

import cn.hutool.core.date.DateUtil;
import com.zhy.interview.entity.Remark;
import com.zhy.interview.service.RemarkService;
import com.zhy.interview.utils.R;
import com.zhy.interview.vo.RemarkVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @date: 2023/5/7 12:30
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/remark")
public class RemarkController {

    @Resource
    private RemarkService remarkService;


    @GetMapping("/updateThumbs")
    public R updateThumbs(Integer thumbsCount,String remarkId){
        Remark remark = remarkService.getById(remarkId);
        remark.setThumbs(thumbsCount);
        remarkService.updateById(remark);
        return R.ok();
    }

    @GetMapping("/getRemark")
    public R getRemark(String titleId,String orderType){
        List<RemarkVo> remarkList= remarkService.getRemark(titleId,orderType);
        return R.ok().setData(remarkList);
    }

    @PostMapping("/comment")
    public R comment(@RequestBody Remark remark){

        remark.setCommentTime(DateUtil.date());
        remark.setThumbs(0);
        log.info("remark:{}",remark);
        remarkService.save(remark);
        return R.ok();
    }

}
