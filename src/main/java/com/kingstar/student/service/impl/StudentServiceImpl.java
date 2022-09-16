package com.kingstar.student.service.impl;

import com.kingstar.student.domain.Student;
import com.kingstar.student.mapper.GradeMapper;
import com.kingstar.student.mapper.StudentMapper;
import com.kingstar.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 查询学生信息列表
     * @param student
     * @return
     */
    @Override
    public List<Student> selectStuList(Student student,Long pageNum,Long pageSize) {
        //如果pageNum和pageSize为null,则赋予默认值
        if (pageNum==null){
            pageNum= 1L;
        }
        if (pageSize==null){
            pageSize= 10L;
        }
        //跳过多少条
        pageNum = (pageNum-1)*pageSize;
        return studentMapper.selectStuList(student,pageNum,pageSize);
    }

    /**
     * 返回条数
     * @param student
     * @return
     */
    @Override
    public long selectTotal(Student student) {
        return studentMapper.selectTotal(student);
    }

    /**
     * 查询详细信息
     * @param stuNumber
     * @return
     */
    @Override
    public Student selectStuByNumber(String stuNumber) {
        return studentMapper.selectStuByNumber(stuNumber);
    }

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    @Override
    public int insertStu(Student student) {
        //获取学号
        String stuNumber = student.getStuNumber();
        if (stuNumber==null || "".equals(stuNumber)){
            throw new RuntimeException("学号不可为空");
        }
        //判断学号是否存在
        if (studentMapper.selectStuByNumber(stuNumber)!=null){
            throw new RuntimeException("学号存在！");
        }
        //获取班级编号
        String graNumber = student.getGraNumber();
        if (graNumber==null || "".equals(graNumber)){
            throw new RuntimeException("班级编号不可为空");
        }
        //判断班级编号是否存在
        if (gradeMapper.selectGraByNumber(graNumber)==null){
            throw new RuntimeException("班级不存在！");
        }
        //写入创建日期
        student.setCreateTime(new Date());

        return studentMapper.insertStu(student);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public int updateStu(Student student) {
        String stuNumber = student.getStuNumber();
        if (stuNumber ==null || "".equals(stuNumber)){
            throw new RuntimeException("学号不可为空");
        }
        //写入修改日期
        student.setUpdateTime(new Date());
        return studentMapper.updateStu(student);
    }

    /**
     * 删除学生信息
     * @param stuNumbers
     * @return
     */
    @Override
    public int deleteStu(String[] stuNumbers) {
        return studentMapper.deleteStu(stuNumbers);
    }
}
