package com.kingstar.student;

import com.kingstar.student.domain.Student;
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
public class StudentTest {

    @Autowired
    private IStudentService studentService;

    @Before
    public void brfore(){
        System.out.println("单元测试开始");
    }

    /**
     * 测试新增学生信息
     */
    @Test
    public void addStu(){

        Student student = new Student();
        student.setStuNumber("20220915");//写入学号
        student.setStuName("测试00");//写入姓名
        student.setSex("1");//写入性别
        student.setBirthday(new Date());//写入出生日期
        student.setCreateTime(new Date());//写入创建时间
        student.setGraNumber("GZ001");//写入班级编号
        student.setGraName("高中一班");//写入班级
        studentService.insertStu(student);

    }

    /**
     * 测试修改学生信息
     */
    @Test
    public void editStu(){
        Student student = new Student();
        student.setStuNumber("20220915");//写入学号
        student.setStuName("测试修改");//写入姓名
        student.setSex("2");//写入性别
//        student.setBirthday(new Date());//写入出生日期
        student.setUpdateTime(new Date());//写入创建时间
//        student.setGraNumber("GZ001");//写入班级编号
//        student.setGraName("高中一班");//写入班级
        studentService.updateStu(student);
    }


    /**
     * 测试删除学生信息
     */
    @Test
    public void delStu(){
        String[] stuNumbers ={"20220915", "20220915001"};
        int i = studentService.deleteStu(stuNumbers);
        System.out.println(i);

    }

    /**
     * 测试查询学生信息
     */
    @Test
    public void selStu(){
        Student student = new Student();
        List<Student> students = studentService.selectStuList(student,1L,3L);
        for (Student s:students) {
            System.out.println(s);
        }
    }

    @Test
    public void selStuByNumber(){
        String stuNumber = "20220915";
        Student student = studentService.selectStuByNumber(stuNumber);
        System.out.println(student);
    }

    @After
    public void after(){
        System.out.println("单元测试结束");
    }


}
