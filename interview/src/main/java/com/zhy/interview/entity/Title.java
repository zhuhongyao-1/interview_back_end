package com.zhy.interview.entity;

import java.util.ArrayList;
import java.util.Date;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.ToString;

/**
 * (Title)表实体类
 *
 * @author makejava
 * @since 2023-05-01 17:52:45
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("title")
@ToString
public class Title  {
    //
    @TableId(value="id",type=IdType.AUTO)
    private Integer id;

    
    private String questionType;
    
    private String difficulty;
    
    private String tag;

    private String titleName;
    
    private String explains;
    
    private String remarks;
    
    private Integer userId;
    
    private Date createTime;
    
    private Integer pageViews;
    
    private Integer collectionNumber;
    
    private Integer messageNumber;




}

