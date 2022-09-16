package com.kingstar.student.model.grade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@ApiModel("修改班级信息")
@Data
public class GradeEdit {


    @ApiModelProperty("班级编号")
    @NotNull(message = "班级编号不可为空")
    @Length(max = 20,message = "班级编号过长,输入上限值为20位")
    private String graNumber;


    @ApiModelProperty("班级名称")
    @Length(max = 20,message = "班级名称过长,输入上限值为20位")
    private String graName;
}
