package com.driver;

public class Teacher {
    private String name;
    private int numberOfStudents;
    private int age;
    //No args Constructor
    public Teacher() {

    }
    //All args constructor
    public Teacher(String name, int numberOfStudents, int age) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
    }
    //Name Getter
    public String getName() {
        return name;
    }
    //Name Setter
    public void setName(String name) {
        this.name = name;
    }
    //No of Students Getter
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    //No of Students Setter
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    //Age Getter
    public int getAge() {
        return age;
    }
    //Age Setter
    public void setAge(int age) {
        this.age = age;
    }
}