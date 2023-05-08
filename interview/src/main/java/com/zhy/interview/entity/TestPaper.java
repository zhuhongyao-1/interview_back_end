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
 * (Tespaper)表实体类
 *
 * @author makejava
 * @since 2023-05-07 21:23:59
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("test_paper")
public class TestPaper {
    //
    @TableId(value="id",type=IdType.AUTO)
    private Integer id;

    private String tag;
    
    private String title;
    
    private String img;
    
    private Integer userId;

    private Date createTime;



}

