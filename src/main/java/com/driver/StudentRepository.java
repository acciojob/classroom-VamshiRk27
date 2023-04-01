package com.driver;

import com.driver.Student;
import com.driver.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentDb= new HashMap<>();
    HashMap<String, Teacher> teacherDb=new HashMap<>();
    HashMap<String,List<String>> pairDb=new HashMap<>();

    //1 Add Student
    public void addStudent(Student student) {
        String name=student.getName();
        if(!studentDb.containsKey(name)){
            studentDb.put(name,student);
        }
    }
    //2 Add Teacher
    public void addTeacher(Teacher teacher) {
        String name=teacher.getName();
        if(!teacherDb.containsKey(name)){
            teacherDb.put(name,teacher);
        }
    }
    //3 Add Student Teacher Pair
    public void addStudentTeacherPair(String studentName,String teacherName){
        List<String> student=pairDb.get(teacherName);
        if(student==null){
            student=new ArrayList<>();
        }
        student.add(studentName);
        pairDb.put(teacherName,student);
    }
    // Get Students database
    public HashMap<String,Student> getAllStudents(){
        return studentDb;
    }
    // Get Teachers database
    public HashMap<String,Teacher> getAllTeachers(){
        return teacherDb;
    }
    // Get Student Teacher Pair
    public HashMap<String,List<String>> getStudentTeacherPair(){
        return pairDb;
    }
}
