package com.driver.models;

public class Student {

    private String name;
    private int age;
    private double averageScore;
    //No args Constructor
    public Student(){

    }
    //All args Constructor
    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }
    //Name Getter
    public String getName() {
        return name;
    }
    //Name Setter
    public void setName(String name) {
        this.name = name;
    }
    //Age Getter
    public int getAge() {
        return age;
    }
    //Age Setter
    public void setAge(int age) {
        this.age = age;
    }
    //Average Score Getter
    public double getAverageScore() {
        return averageScore;
    }
    //Average Score Setter
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
