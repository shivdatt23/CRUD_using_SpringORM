package org.example.dao;

import org.example.entity.Student;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;
//save methods
    @Transactional
    public int insert(Student student){

        Integer i=(Integer) hibernateTemplate.save(student);
        return i;
    }

    public Student getStudent(int studentId){
//        single data
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        return student;

    }
//    select multiple data
    public List<Student> getAllstudent(){
        List<Student> s_list=this.hibernateTemplate.loadAll(Student.class);
         return s_list;

    }
//delete
    @Transactional
    public void deleteStudent(int studentId){
    Student student=this.hibernateTemplate.get(Student.class,studentId);
    this.hibernateTemplate.delete(student);
    }

    //update
    @Transactional
    public void updateStudent(int id,String u_name,String u_city){
        Student u_student=this.hibernateTemplate.get(Student.class,id);
        u_student.setStudentName(u_name);
        u_student.setStudentCity(u_city);
        this.hibernateTemplate.update(u_student);

    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
