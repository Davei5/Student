package com.kingstar.student.controller;

import com.kingstar.student.config.AjaxResult;
import com.kingstar.student.domain.Student;
import com.kingstar.student.model.student.StudentAdd;
import com.kingstar.student.model.student.StudentEdit;
import com.kingstar.student.model.student.StudentReq;
import com.kingstar.student.service.IStudentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /** 查询学生信息 */
    @PostMapping("/list")
    @ApiOperation("查询学生信息列表")
    public AjaxResult selectStuList(@RequestBody StudentReq studentReq){

        Student student = new Student();
        //页码
        Long pageNum = studentReq.getPageNum();
        //每页条数
        Long pageSize = studentReq.getPageSize();
        BeanUtils.copyProperties(studentReq,student);

        List<Student> students = studentService.selectStuList(student,pageNum,pageSize);
        long total= studentService.selectTotal(student);

        return AjaxResult.success(students).put("total",total);
    }

    @ApiOperation("获取学生详细信息")
    @ApiImplicitParam(name = "stuNumber", value = "学号", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    @GetMapping("/{stuNumber}")
    public AjaxResult selectStuByNumber(@PathVariable("stuNumber")String stuNumber){
        return AjaxResult.success(studentService.selectStuByNumber(stuNumber));
    }

    /** 添加学生信息 */
    @PostMapping("/add")
    @ApiOperation("新增学生信息")
    public AjaxResult insertStu(@Valid @RequestBody StudentAdd studentAdd){
        Student student = new Student();
        BeanUtils.copyProperties(studentAdd,student);
        int i = studentService.insertStu(student);
        return AjaxResult.success(i);
    }

    /** 修改学生信息 */
    @ApiOperation("修改学生信息")
    @PostMapping("/update")
    public AjaxResult editStu(@RequestBody @Valid StudentEdit studentEdit){
        Student student = new Student();
        BeanUtils.copyProperties(studentEdit,student);
        return AjaxResult.success(studentService.updateStu(student));

    }

    /** 删除学生信息 */
    @ApiOperation("删除学生信息")
    @ApiImplicitParam(name = "stuNumber", value = "学号", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    @GetMapping("/delete/{stuNumbers}")
    public AjaxResult delStu(@PathVariable String[] stuNumbers){
        return AjaxResult.success(studentService.deleteStu(stuNumbers));
    }



}
