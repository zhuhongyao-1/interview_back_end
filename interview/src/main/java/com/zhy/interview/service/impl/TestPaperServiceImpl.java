package com.zhy.interview.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.TestPaper;
import com.zhy.interview.mapper.TestPaperMapper;
import org.springframework.stereotype.Service;

import com.zhy.interview.service.TestPaperService;

/**
 * (Tespaper)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 21:23:59
 */
@Service("tespaperService")
public class TestPaperServiceImpl extends ServiceImpl<TestPaperMapper, TestPaper> implements TestPaperService {

}

