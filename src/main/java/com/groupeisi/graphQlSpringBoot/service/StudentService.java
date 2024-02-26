package com.groupeisi.graphQlSpringBoot.service;
import com.groupeisi.graphQlSpringBoot.entity.Student;
import com.groupeisi.graphQlSpringBoot.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public long countStudents() {
        return studentRepository.count();
    }


}
