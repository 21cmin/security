package com.example.security.entity;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Student {
    private final Long id;
    private final String name;

    public static final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "James Bond"),
            new Student(2L, "Maria Jones"),
            new Student(3L, "Anna Smith")
    );
}
