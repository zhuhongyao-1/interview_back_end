package com.zhy.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.interview.entity.ViewRecord;
import com.zhy.interview.mapper.ViewRecordMapper;
import com.zhy.interview.service.ViewRecordService;
import org.springframework.stereotype.Service;

/**
 * (ViewRecord)表服务实现类
 *
 * @author makejava
 * @since 2023-05-15 20:49:30
 */
@Service("viewRecordService")
public class ViewRecordServiceImpl extends ServiceImpl<ViewRecordMapper, ViewRecord> implements ViewRecordService {

}

