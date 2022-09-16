package com.kingstar.student.model.grade;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@ApiModel("班级信息新增")
@Data
public class GradeAdd {

    @ApiModelProperty(value = "班级编号",required = true)
    @NotNull(message = "班级编号不可为空")
    @Length(max = 20,message = "班级编号过长,输入上限值为20位")
    private String graNumber;


    @ApiModelProperty(value = "班级名称",required = true)
    @Length(max = 20,message = "班级名称过长,输入上限值为20位")
    private String graName;


}
