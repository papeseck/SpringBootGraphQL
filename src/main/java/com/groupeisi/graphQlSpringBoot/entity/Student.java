package com.groupeisi.graphQlSpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String email;
    private String[] address;
}
