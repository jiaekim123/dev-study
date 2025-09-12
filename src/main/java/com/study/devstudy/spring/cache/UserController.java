package com.study.devstudy.spring.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    public User findById(Long id) {
        return userService.findById(id);
    }
}
