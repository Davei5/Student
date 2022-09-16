package com.kingstar.student.model.student;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("学生信息新增")
@Data
public class StudentAdd implements Serializable {

    @ApiModelProperty(value = "学号",required = true)
    @NotNull(message = "学号不可为空")
    @Length(max = 20,message = "学号过长,输入上限值为20位")
    private String stuNumber;

    @ApiModelProperty(value = "姓名",required = true)
    @Length(max = 10,message = "姓名过长,输入上限值为10位")
    private String stuName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("出生日期")
    private String birthday;

    @ApiModelProperty(value = "班级编号",required = true)
    @NotNull(message = "班级编号不可为空")
    @Length(max = 20,message = "班级编号过长,输入上限值为20位")
    private String graNumber;


    @ApiModelProperty(value = "班级名称",required = true)
    @Length(max = 20,message = "班级名称过长,输入上限值为20位")
    private String graName;


}
