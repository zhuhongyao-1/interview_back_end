package com.zhy.interview.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.ToString;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2023-04-22 16:28:47
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@ToString
public class User  {

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String sex;
    
    private String headUrl;
    
    private String score;
    
    private Integer member;
    
    private Date createTime;
    
    private String interest;

    private String email;

    private String introduction;

    private Integer collectionCount;







}

