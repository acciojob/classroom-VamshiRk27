package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;
    //1 Add Student
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }
    //2 Add Teacher
    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        studentService.addTeacher(teacher);
        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }
    //3 Pair Student and Teacher
    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){
        studentService.addStudentTeacherPair(student,teacher);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }
    //4 Get Student by student name
    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = studentService.getStudentByName(name); // Assign student by calling service layer method
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    //5 Get Teacher by teacher name
    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = studentService.getTeacherByName(name); // Assign student by calling service layer method
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }
    //6 Get List of students name for a given teacher name
    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = studentService.getStudentsByTeacherName(teacher); // Assign list of student by calling service layer method
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }
    //7 Get List of all students
    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = studentService.getAllStudents(); // Assign list of student by calling service layer method
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }
    //8 Delete a teacher and its students from the records
    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        studentService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }
    //9 Delete all teachers and all students by them
    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){
        studentService.deleteAllTeachers();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}
