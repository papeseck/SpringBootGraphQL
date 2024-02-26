package com.groupeisi.graphQlSpringBoot.repository;

import com.groupeisi.graphQlSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
}
