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
 * (Remark)表实体类
 *
 * @author makejava
 * @since 2023-05-07 11:58:06
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("remark")
public class Remark  {
    //
    @TableId(value="id",type=IdType.AUTO)
    private Integer id;

    private String commentContent;
    
    private Date commentTime;
    
    private String commentImg;
    
    private Integer thumbs;
    
    private Integer userId;

    private Integer titleId;

}

