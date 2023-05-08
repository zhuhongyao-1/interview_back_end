package com.zhy.interview.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Reply)表实体类
 *
 * @author makejava
 * @since 2023-05-07 15:13:18
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reply")
public class Reply {

    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    
    private String replyContent;
    
    private Date replyTime;
    
    private Integer remarkId;





}

