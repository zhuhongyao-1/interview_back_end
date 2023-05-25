package com.zhy.interview.controller;

import cn.hutool.core.date.DateUtil;
import com.zhy.interview.entity.TestPaper;
import com.zhy.interview.service.TestPaperService;
import com.zhy.interview.utils.R;
import com.zhy.interview.vo.TestPaperVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date: 2023/5/7 21:33
 * @description:
 */
@RestController
@RequestMapping("/testpaper")
@Slf4j
public class TestPaperController {
    @Resource
    private TestPaperService testPaperService;

    @GetMapping("/papersearchall")
    public R paperSearchAll(){
        List<TestPaperVo> testPapers= testPaperService.paperSearchAll();
       return R.ok().setData(testPapers);
    }

    @PostMapping("/inserttextpaper")
    public R inserttextpaper(@RequestBody TestPaperVo testPaperVo){
        log.info("testpaperVo:{}",testPaperVo);

        TestPaper testPaper = new TestPaper();
        BeanUtils.copyProperties(testPaperVo,testPaper);

        List<String> tag = testPaperVo.getTag();

        StringBuilder sb = new StringBuilder();
        tag.forEach(item->{
            sb.append(item).append(",");
        });

        testPaper.setTags(sb.toString());
        testPaper.setCreateTime(DateUtil.date());
        testPaper.setViewNum(0);

        testPaperService.save(testPaper);

      return R.ok();
    }
}
