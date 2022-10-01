package com.example.demo.buisness;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(Student payload) {
        Student student = new Student();
        student.setId(payload.getId());
        student.setName(payload.getName());
        studentRepository.save(student);
        return "Student Saved Successfuly";
    }

    public Student findById(String id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Student Not Found"));
    }

    public Student updateById(Student payload) throws Exception {
        Student student = studentRepository.findById(payload.getId()).orElseThrow(() -> new Exception("Student Not Found"));
        student.setName(payload.getName());
        studentRepository.save(student);
        return student;
    }

    public void deleteStudentById(String id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new Exception("Student Not Found"));
        studentRepository.delete(student);
    }
}
