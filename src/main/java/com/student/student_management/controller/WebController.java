package com.student.student_management.controller;

import com.student.student_management.Model.Student;
import com.student.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("newStudent", new Student());
        return "index";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("newStudent") Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @GetMapping("/deleteStudent/{roll}")
    public String deleteStudent(@PathVariable int roll) {
        studentRepository.deleteById(roll);
        return "redirect:/";
    }

    // ✏️ Edit Student
    @GetMapping("/editStudent/{roll}")
    public String editStudent(@PathVariable int roll, Model model) {
        Student student = studentRepository.findById(roll).orElse(null);
        model.addAttribute("student", student);
        return "edit"; // Loads edit.html
    }

    // ✅ Update Student
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }
}
