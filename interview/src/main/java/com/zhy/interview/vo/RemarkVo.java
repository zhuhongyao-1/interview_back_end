package com.zhy.interview.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @date: 2023/5/7 13:48
 * @description:
 */
@Data
public class RemarkVo {
    private String commentContent;

    private Date commentTime;

    private String commentImg;

    private Integer thumbs;

    private String headPortrait;

    private Integer titleId;
    private Integer id;

    private List<ReplyVo> replyVos=new ArrayList<>();
}
