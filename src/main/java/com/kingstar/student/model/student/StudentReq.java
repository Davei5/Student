package com.kingstar.student.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("学生信息查询")
@Data
public class StudentReq {

    @ApiModelProperty("学号")
    private String stuNumber;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("班级")
    private String graNumber;

    @ApiModelProperty("页码")
    private Long pageNum;
    @ApiModelProperty("每页条数")
    private Long pageSize;
}
