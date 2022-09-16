package com.kingstar.student.mapper;

import com.kingstar.student.domain.Grade;
import com.kingstar.student.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {

    /**
     * 查询学生信息
     * @param grade
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Grade> selectGraList(@Param("grade") Grade grade,@Param("pageNum") Long pageNum,@Param("pageSize") Long pageSize);

    /**
     * 返回条数
     * @param grade
     * @return
     */
    public long selectTotal(Grade grade);

    /**
     * 查询学生详细信息
     * @param graNumber
     * @return
     */
    public Grade selectGraByNumber(String graNumber);

    /**
     * 新增学生信息
     * @param grade
     * @return
     */
    public int insertGra(Grade grade);

    /**
     * 修改学生信息
     * @param grade
     * @return
     */
    public int updateGra(Grade grade);

    /**
     * 根据学号删除
     * @param graNumbers
     * @return
     */
    public int deleteGra(String[] graNumbers);



}
