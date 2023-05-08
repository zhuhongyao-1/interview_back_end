package com.zhy.interview.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zhy.interview.mapper.CollectionInfoMapper;
import com.zhy.interview.service.CollectionInfoService;
import com.zhy.interview.entity.CollectionInfo;
import org.springframework.stereotype.Service;

/**
 * (CollectionInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-05-03 18:28:09
 */
@Service("collectionInfoService")
public class CollectionInfoServiceImpl extends ServiceImpl<CollectionInfoMapper, CollectionInfo> implements CollectionInfoService {

}

