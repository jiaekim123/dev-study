package com.study.devstudy.spring.cache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameAndAge(String name, int age);
}
