package com.student.student_management.controller;

import com.student.student_management.Model.Student;
import com.student.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // ➕ Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    // 📋 Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // 🔍 Get a student by roll number
    @GetMapping("/{roll}")
    public Student getStudent(@PathVariable int roll) {
        return repo.findById(roll).orElse(null);
    }

    // ✏️ Update a student's record
    @PutMapping("/{roll}")
    public Student updateStudent(@PathVariable int roll, @RequestBody Student student) {
        student.setRoll(roll);
        return repo.save(student);
    }

    // 🗑️ Delete a student
    @DeleteMapping("/{roll}")
    public String deleteStudent(@PathVariable int roll) {
        repo.deleteById(roll);
        return "Student deleted with roll: " + roll;
    }
}

