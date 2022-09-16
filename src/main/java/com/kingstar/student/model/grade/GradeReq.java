package com.kingstar.student.model.grade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("班级信息查询")
@Data
public class GradeReq {

    @ApiModelProperty("班级编号")
    private String graNumber;

    @ApiModelProperty("页码")
    private Long pageNum;
    @ApiModelProperty("每页条数")
    private Long pageSize;
}
