package com.kingstar.student.mapper;

import com.kingstar.student.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询学生信息
     * @param student
     * @param pageNum 页码
     * @param pageSize 每页参数
     * @return
     */
    public List<Student> selectStuList(@Param("student") Student student, @Param("pageNum") Long pageNum, @Param("pageSize") Long pageSize);

    /**
     * 返回条数
     * @param student
     * @return
     */
    public long selectTotal(Student student);

    /**
     * 查询学生详细信息
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
