package com.kingstar.student.service;

import com.kingstar.student.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {

    /**
     * 查询学生信息列表
     * @param student
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Student> selectStuList(Student student,Long pageNum,Long pageSize);

    /**
     * 返回条数
     * @param student
     * @return
     */
    public long selectTotal(Student student);

    /**
     * 获取学生详细信息
     * @param stuNumber
     * @return
     */
    public Student selectStuByNumber(String stuNumber);

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    public int insertStu(Student student);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public int updateStu(Student student);

    /**
     * 根据学号删除
     * @param stuNumbers
     * @return
     */
    public int deleteStu(String[] stuNumbers);


}
