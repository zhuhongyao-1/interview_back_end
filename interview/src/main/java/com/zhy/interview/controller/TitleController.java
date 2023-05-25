package com.zhy.interview.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhy.interview.entity.Title;
import com.zhy.interview.entity.User;
import com.zhy.interview.entity.ViewRecord;
import com.zhy.interview.service.TitleService;
import com.zhy.interview.service.UserService;
import com.zhy.interview.service.ViewRecordService;
import com.zhy.interview.utils.R;
import com.zhy.interview.vo.QueryVo;
import com.zhy.interview.vo.TitleInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @date: 2023/5/1 17:54
 * @description:
 */
@RestController
@RequestMapping("/title")
@Slf4j
public class TitleController {
    @Resource
    private TitleService titleService;

    @Resource
    private UserService userService;

    @Resource
    private ViewRecordService viewRecordService;



    @PostMapping("/query")
    public R query(@RequestBody QueryVo queryVo){
        log.info("queryVo:{}",queryVo);
       List<Title> titleList= titleService.queryByCondition(queryVo);
        return R.ok().setData(titleList);
    }

    @PostMapping("/save")
    public R save(@RequestBody Title title) {
        log.info("title:{}", title);

        title.setMessageNumber(0);
        title.setCollectionNumber(0);
        title.setPageViews(0);
        title.setCreateTime(DateUtil.date());
        titleService.save(title);
        return R.ok();

    }

    @GetMapping("/getTitle")
    public R getTitle(String tag) {
        log.info("titleName:{}", tag);
        List<Title> titleList = titleService.getTitle(tag);
        return R.ok().setData(titleList);
    }

    @GetMapping("/getTitleOne")
    public R getTitleOne(String titleId) {
        TitleInfoVo titleInfoVo = new TitleInfoVo();
        Title title = titleService.getById(titleId);

        title.setPageViews(title.getPageViews() + 1);
        titleService.updateById(title);
        BeanUtils.copyProperties(title, titleInfoVo);
        User byId = userService.getById(title.getUserId());
        titleInfoVo.setUsername(byId.getUsername());
        titleInfoVo.setHeadUrl(byId.getHeadUrl());

        String titleName = title.getTitleName().replaceAll("\\<.*?\\>", "");
        String[] split = ToAnalysis.parse(titleName).toStringWithOutNature().split(",");


        List<Title> titleList = titleService.getTitleListbyLike(split, title.getQuestionType(), title);
        titleInfoVo.setTitleList(titleList);

        ViewRecord viewRecord = viewRecordService.getOne(new QueryWrapper<ViewRecord>().eq("user_id", title.getUserId()).eq("title_id", title.getId()));
        if(viewRecord!=null){
            viewRecord.setUpdateTime(new Date());
            viewRecordService.updateById(viewRecord);
        }else {
            viewRecord=new ViewRecord();
            viewRecord.setTitleId(title.getId());
            viewRecord.setUserId(title.getUserId());
            viewRecord.setCreateTime(new Date());
            viewRecord.setUpdateTime(new Date());
            viewRecordService.save(viewRecord);
        }

        return R.ok().setData(titleInfoVo);
    }
}
