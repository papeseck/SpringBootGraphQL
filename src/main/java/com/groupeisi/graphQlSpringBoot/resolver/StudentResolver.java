package com.groupeisi.graphQlSpringBoot.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.groupeisi.graphQlSpringBoot.entity.Student;
import com.groupeisi.graphQlSpringBoot.service.StudentService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.List;

@Component
public class StudentResolver implements GraphQLResolver<Student> {

    @Autowired
    private StudentService studentService;

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    public long countStudents() {
        return studentService.countStudents();
    }
}

