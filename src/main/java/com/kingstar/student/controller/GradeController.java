package com.kingstar.student.controller;

import com.kingstar.student.config.AjaxResult;
import com.kingstar.student.domain.Grade;
import com.kingstar.student.domain.Student;
import com.kingstar.student.model.grade.GradeAdd;
import com.kingstar.student.model.grade.GradeEdit;
import com.kingstar.student.model.grade.GradeReq;
import com.kingstar.student.service.IGradeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private IGradeService gradeService;

    /** 查询班级信息 */
    @PostMapping("/list")
    @ApiOperation("查询班级信息列表")
    public AjaxResult selectStuList(@RequestBody GradeReq gradeReq){

        Student student = new Student();
        Grade grade = new Grade();
        //页码
        Long pageNum = gradeReq.getPageNum();
        //每页条数
        Long pageSize = gradeReq.getPageSize();
        BeanUtils.copyProperties(gradeReq,grade);

        List<Grade> grades = gradeService.selectGraList(grade,pageNum,pageSize);
        long total= gradeService.selectTotal(grade);

        return AjaxResult.success(grades).put("total",total);
    }

    @ApiOperation("获取班级详细信息")
    @ApiImplicitParam(name = "graNumber", value = "班级编号", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    @GetMapping("/{graNumber}")
    public AjaxResult selectStuByNumber(@PathVariable("graNumber")String graNumber){
        return AjaxResult.success(gradeService.selectGraByNumber(graNumber));
    }

    /** 添加班级信息 */
    @PostMapping("/add")
    @ApiOperation("新增班级信息")
    public AjaxResult insertStu(@RequestBody @Validated GradeAdd gradeAdd){
        Grade grade = new Grade();
        BeanUtils.copyProperties(gradeAdd,grade);
        return AjaxResult.success(gradeService.insertGra(grade));
    }

    /** 修改班级信息 */
    @ApiOperation("修改班级信息")
    @PostMapping("/update")
    public AjaxResult editStu(@RequestBody @Validated GradeEdit gradeEdit){
        Grade grade = new Grade();
        BeanUtils.copyProperties(gradeEdit,grade);
        return AjaxResult.success(gradeService.updateGra(grade));

    }

    /** 删除班级信息 */
    @ApiOperation("删除班级信息")
    @ApiImplicitParam(name = "graNumbers", value = "班级编号", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    @GetMapping("/delete/{graNumbers}")
    public AjaxResult delStu(@PathVariable String[] graNumbers){
        return AjaxResult.success(gradeService.deleteGra(graNumbers));
    }
}
