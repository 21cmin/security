package com.example.security.controller;

import com.example.security.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        return Student.STUDENTS;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return Student.STUDENTS.stream().filter(student -> {
            log.info(String.format("student id: %d", student.getId()));
            return student.getId().equals(studentId);
        }).findAny().orElseThrow(() -> new IllegalStateException(String.format("Student %d does not exists.", studentId)));
    }
}
