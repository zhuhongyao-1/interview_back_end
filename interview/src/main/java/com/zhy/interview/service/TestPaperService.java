package com.zhy.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhy.interview.entity.TestPaper;
import com.zhy.interview.entity.ViewRecord;
import com.zhy.interview.vo.TestPaperVo;

import java.util.List;

/**
 * (Tespaper)表服务接口
 *
 * @author makejava
 * @since 2023-05-07 21:23:59
 */
public interface TestPaperService extends IService<TestPaper> {

    List<TestPaperVo> paperSearchAll();

}

