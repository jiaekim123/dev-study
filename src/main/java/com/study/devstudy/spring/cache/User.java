package com.study.devstudy.spring.cache;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private int age;
}
