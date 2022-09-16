package com.kingstar.student.domain;

import lombok.Data;

import java.util.Date;

/**
 * 班级信息表
 */
@Data
public class Grade {

    /** 班级表id */
    private Long id;

    /** 班级编号 */
    private String graNumber;

    /** 班级名称 */
    private String graName;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    /** 状态 1：有效 2：无效 */
    private String status;

}
