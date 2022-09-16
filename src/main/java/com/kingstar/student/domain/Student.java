package com.kingstar.student.domain;

import lombok.Data;

import java.util.Date;

/**
 * 学生信息表
 */
@Data
public class Student {

    /** 学生表id */
    private Long id;

    /** 学号 */
    private String stuNumber;

    /** 姓名 */
    private String stuName;

    /** 性别 */
    private String sex;

    /** 出生年月 */
    private Date birthday;

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

    /** 分页参数
    /** 页码
    private Long pageNum;
    /** 每页条数
    private Long pageSize; */

}
