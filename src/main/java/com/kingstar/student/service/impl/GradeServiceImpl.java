package com.kingstar.student.service.impl;

import com.kingstar.student.domain.Grade;
import com.kingstar.student.domain.Student;
import com.kingstar.student.mapper.GradeMapper;
import com.kingstar.student.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 分页查询班级列表
     * @param grade
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Grade> selectGraList(Grade grade,Long pageNum,Long pageSize) {
        //如果pageNum和pageSize为null,则赋予默认值
        if (pageNum==null){
            pageNum= 1L;
        }
        if (pageSize==null){
            pageSize= 10L;
        }
        //跳过多少条
        pageNum = (pageNum-1)*pageSize;
        return gradeMapper.selectGraList(grade,pageNum,pageSize);
    }

    /**
     * 获取查询总条数
     * @param grade
     * @return
     */
    @Override
    public long selectTotal(Grade grade) {
        return gradeMapper.selectTotal(grade);
    }

    /**
     * 根据班级编号查询详细信息
     * @param graNumber
     * @return
     */
    @Override
    public Grade selectGraByNumber(String graNumber) {
        return gradeMapper.selectGraByNumber(graNumber);
    }

    /**
     * 新增班级
     * @param grade
     * @return
     */
    @Override
    public int insertGra(Grade grade) {
        //获取班级编号，判断是否存在
        String graNumber = grade.getGraNumber();
        if (graNumber==null || "".equals(graNumber)){
            throw new RuntimeException("班级编号不可为空");
        }
        if (gradeMapper.selectGraByNumber(graNumber)!=null){
            throw new RuntimeException("班级编号存在");
        }
        //写入创建时间
        grade.setCreateTime(new Date());
        return gradeMapper.insertGra(grade);
    }

    /**
     * 修改班级
     * @param grade
     * @return
     */
    @Override
    public int updateGra(Grade grade) {
        //获取班级编号
        String graNumber = grade.getGraNumber();
        if (graNumber==null || "".equals(graNumber)){
            throw new RuntimeException("班级编号不可为空");
        }
        //写入修改时间
        grade.setUpdateTime(new Date());
        return gradeMapper.updateGra(grade);
    }

    /**
     * 删除班级，假删除
     * @param graNumbers
     * @return
     */
    @Override
    public int deleteGra(String[] graNumbers) {
        return gradeMapper.deleteGra(graNumbers);
    }
}
