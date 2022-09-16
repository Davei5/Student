package com.kingstar.student.service;

import com.kingstar.student.domain.Grade;
import com.kingstar.student.domain.Student;

import java.util.List;

public interface IGradeService {

    /**
     * 查询班级信息列表
     * @param grade
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Grade> selectGraList(Grade grade,Long pageNum,Long pageSize);

    /**
     * 返回条数
     * @param student
     * @return
     */
    public long selectTotal(Grade grade);

    /**
     * 获取班级详细信息
     * @param graNumber
     * @return
     */
    public Grade selectGraByNumber(String graNumber);

    /**
     * 新增班级信息
     * @param grade
     * @return
     */
    public int insertGra(Grade grade);

    /**
     * 修改班级信息
     * @param grade
     * @return
     */
    public int updateGra(Grade grade);

    /**
     * 根据班级编号删除
     * @param graNumbers
     * @return
     */
    public int deleteGra(String[] graNumbers);

}
