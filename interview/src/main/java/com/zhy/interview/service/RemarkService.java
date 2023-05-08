package com.zhy.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhy.interview.entity.Remark;
import com.zhy.interview.vo.RemarkVo;

import java.util.List;


/**
 * (Remark)表服务接口
 *
 * @author makejava
 * @since 2023-05-07 11:58:06
 */
public interface RemarkService extends IService<Remark> {

    List<RemarkVo> getRemark(String titleId,String orderType);
}

