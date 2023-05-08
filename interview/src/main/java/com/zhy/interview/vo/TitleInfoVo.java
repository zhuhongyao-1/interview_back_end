package com.zhy.interview.vo;

import com.zhy.interview.entity.Title;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @date: 2023/5/3 16:17
 * @description:
 */
@Data
public class TitleInfoVo {

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


    private String username;

    private String headUrl;

    private List<Title> titleList=new ArrayList<>();

}
