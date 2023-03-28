package com.driver.service;

import com.driver.repository.StudentRepository;
import com.driver.models.Student;
import com.driver.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //1 Add student
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
    //2 Add Teacher
    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }
    //3 Add Student Teacher Pair
    public void addStudentTeacherPair(String student,String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);
    }
    //4 Get Student by Student Name
    public Student getStudentByName(String name){
        HashMap<String, Student> hm=studentRepository.getAllStudents();
        for(String m:hm.keySet()){
            if(m.equals(name)){
                return hm.get(m);
            }
        }
        return null;
    }
    //5 Get Teacher by teacher name
    public Teacher getTeacherByName(String name){
        HashMap<String,Teacher> hm=studentRepository.getAllTeachers();
        for(String m:hm.keySet()){
            if(m.equals(name)){
                return hm.get(m);
            }
        }
        return null;
    }
    //6 Get List of students name for a given teacher name
    public List<String> getStudentsByTeacherName(String teacherName) {
        HashMap<String,List<String>> hm=studentRepository.getStudentTeacherPair();
        return hm.get(teacherName);
    }
    //7 Get List of all students
    public List<String> getAllStudents(){
        HashMap<String, Student> hm=studentRepository.getAllStudents();
        return new ArrayList<>(hm.keySet());
    }
    //8 Delete a teacher and its students from the records
    public void deleteTeacherByName(String teacher){
        HashMap<String,List<String>> pairDb=studentRepository.getStudentTeacherPair();
        HashMap<String,Teacher> teacherDb=studentRepository.getAllTeachers();
        //removed from pairs Database
        for(String teacherName:pairDb.keySet()){
            if(teacherName.equals(teacher)){
                pairDb.remove(teacherName);
            }
        }
        //removed from teachers database
        teacherDb.remove(teacher);
    }
    //9 Delete all teachers and all students by them
    public void deleteAllTeachers(){
        HashMap<String,List<String>> pairDb=studentRepository.getStudentTeacherPair();
        HashMap<String,Teacher> teacherDb=studentRepository.getAllTeachers();
        pairDb.clear();
        teacherDb.clear();
    }

}
