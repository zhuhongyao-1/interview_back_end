package com.zhy.interview.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @date: 2023/5/9 21:00
 * @description:
 */
@Data
public class TestPaperVo {
    private Integer id;

    private List<String> tag;

    private String title;

    private String img;

    private Integer userId;

    private Date createTime;

    private Integer viewNum;
}
