package com.zhy.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhy.interview.entity.CollectionInfo;

import java.util.List;


/**
 * (CollectionInfo)表服务接口
 *
 * @author makejava
 * @since 2023-05-03 18:28:09
 */
public interface CollectionInfoService extends IService<CollectionInfo> {

    List<CollectionInfo> getCollectionInfoByUserId(String userId);
}

