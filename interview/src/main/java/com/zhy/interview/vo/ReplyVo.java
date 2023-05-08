package com.zhy.interview.vo;

import lombok.Data;

import java.util.Date;

/**
 * @date: 2023/5/7 15:20
 * @description:
 */
@Data
public class ReplyVo {
    private Integer id;

    private String replyContent;

    private Date replyTime;

    private Integer remarkId;

    private String username;

    private String headPortrait;


}
