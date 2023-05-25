package com.zhy.interview.entity;


import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
/**
 * (ViewRecord)表实体类
 *
 * @author makejava
 * @since 2023-05-15 20:49:30
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("view_record")
public class ViewRecord  {

    @TableId(value="id",type=IdType.AUTO)
    private Integer id;
    
    private Integer userId;
    
    private Integer titleId;

    private Date createTime;

    private Date updateTime;



}

