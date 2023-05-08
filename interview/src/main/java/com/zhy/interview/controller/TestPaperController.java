package com.zhy.interview.controller;

import com.zhy.interview.entity.TestPaper;
import com.zhy.interview.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @date: 2023/5/7 21:33
 * @description:
 */
@RestController
@RequestMapping("/testpaper")
@Slf4j
public class TestPaperController {
    @PostMapping("/inserttextpaper")
    public R inserttextpaper(@RequestBody TestPaper testPaper){
      log.info("testpaper:{}",testPaper);
      return R.ok();
    }
}
