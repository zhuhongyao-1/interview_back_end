package com.zhy.interview.vo;

import lombok.Data;

/**
 * @date: 2023/5/7 17:05
 * @description:
 */
@Data
public class QueryVo {
    private String search;
    private String tag;
    private String  questionType;
    private String difficulty;

    private Integer orderType;

}
