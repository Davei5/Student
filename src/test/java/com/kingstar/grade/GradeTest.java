package com.kingstar.student;

import com.kingstar.student.domain.Grade;
import com.kingstar.student.domain.Student;
import com.kingstar.student.service.IGradeService;
import com.kingstar.student.service.IStudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GradeTest {

    @Autowired
    private IGradeService gradeService;

    @Before
    public void brfore(){
        System.out.println("单元测试开始");
    }

    /**
     * 测试新增班级信息
     */
    @Test
    public void addGra(){

        Grade grade = new Grade();
        grade.setGraNumber("GZ001");//写入班级编号
        grade.setGraName("高中一班");//写入班级
        grade.setCreateTime(new Date());//写入创建时间
        int i = gradeService.insertGra(grade);
        System.out.println(i);

    }

    /**
     * 测试修改班级信息
     */
    @Test
    public void editStu(){
        Grade grade = new Grade();
        grade.setUpdateTime(new Date());//写入修改时间
        grade.setGraNumber("GZ003");//写入班级编号
        grade.setGraName("高中三班");
        int i = gradeService.updateGra(grade);
    }


    /**
     * 测试信息班级
     */
    @Test
    public void delGra(){
        String[] graNumber ={"GZ003", "GZ001"};
        int i = gradeService.deleteGra(graNumber);
        System.out.println(i);

    }

    /**
     * 测试查询班级信息
     */
    @Test
    public void selGra(){
        Grade grade = new Grade();
        grade.setGraNumber("0");
        List<Grade> grades = gradeService.selectGraList(grade,0L,2L);
        for (Grade s:grades) {
            System.out.println(s);
        }
    }

    /**
     * 测试根据班级编号查询详细信息
     */
    @Test
    public void selGraByNumber(){
        String graNumber = "GZ001";
        Grade grade = gradeService.selectGraByNumber(graNumber);
        System.out.println(grade);
    }

    @After
    public void after(){
        System.out.println("单元测试结束");
    }


}
