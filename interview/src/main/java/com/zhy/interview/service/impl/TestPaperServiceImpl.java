package com.zhy.interview.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.TestPaper;
import com.zhy.interview.mapper.TestPaperMapper;
import com.zhy.interview.vo.TestPaperVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zhy.interview.service.TestPaperService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Tespaper)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 21:23:59
 */
@Service("tespaperService")
public class TestPaperServiceImpl extends ServiceImpl<TestPaperMapper, TestPaper> implements TestPaperService {

    @Override
    public List<TestPaperVo> paperSearchAll() {
        List<TestPaper> testPapers = baseMapper.selectList(null);

        List<TestPaperVo> testPaperVos = testPapers.stream().map(item -> {
            TestPaperVo testPaperVo = new TestPaperVo();
            BeanUtils.copyProperties(item, testPaperVo);
            String tags = item.getTags();
            String[] split = tags.split(",");
            List<String> strings = Arrays.asList(split);
            testPaperVo.setTag(strings);
            return testPaperVo;
        }).collect(Collectors.toList());

        return testPaperVos;
    }
}

