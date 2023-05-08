package com.zhy.interview.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
/**
 * (CollectionInfo)表实体类
 *
 * @author makejava
 * @since 2023-05-03 18:28:09
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("collection_info")
public class CollectionInfo  {
    //
    @TableId(value="id",type=IdType.AUTO)
    private Integer id;

    
    private Integer userid;
    
    private Integer titleid;



}

