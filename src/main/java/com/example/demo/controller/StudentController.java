package com.example.demo.controller;

import com.example.demo.buisness.StudentService;
import com.example.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @Cacheable(value = "student", key = "#id")
    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable String id) throws Exception {
        return studentService.findById(id);
    }

    @CachePut(value = "student", key = "#student.id")
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) throws Exception {
        return studentService.updateById(student);
    }

    @CacheEvict(value = "student", key = "#id")
    @DeleteMapping("/del/{id}")
    public void deleteStudent(@PathVariable String id) throws Exception {
        studentService.deleteStudentById(id);
    }

}
