package com.student.student_management.repository;

import com.student.student_management.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface automatically provides CRUD operations
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
