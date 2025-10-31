package com.student.student_management.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private int roll;
    private String name;
    private double marks;

    // Default constructor (required by JPA)
    public Student() {}

    // Parameterized constructor
    public Student(int roll, String name, double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
