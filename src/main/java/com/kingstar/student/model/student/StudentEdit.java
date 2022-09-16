package com.kingstar.student.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@ApiModel("修改学生信息")
@Data
public class StudentEdit {

    @ApiModelProperty("学号")
    @NotNull(message = "学号不可为空")
    @Length(max = 20,message = "学号过长,输入上限值为20位")
    private String stuNumber;

    @ApiModelProperty("姓名")
    @Length(max = 10,message = "姓名过长,输入上限值为10位")
    private String stuName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("出生日期")
    private String birthday;

    @ApiModelProperty("班级编号")
    @NotNull(message = "班级编号不可为空")
    @Length(max = 20,message = "班级编号过长,输入上限值为20位")
    private String graNumber;


    @ApiModelProperty("班级名称")
    @Length(max = 20,message = "班级名称过长,输入上限值为20位")
    private String graName;
}
