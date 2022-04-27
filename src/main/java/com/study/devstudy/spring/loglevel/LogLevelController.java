package com.study.devstudy.spring.loglevel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2022/04/27
 */
@RestController
public class LogLevelController {

    @GetMapping("/logs/level")
    public String log(){
        CustomLogger logLevel = new CustomLogger();
        logLevel.logging();
        return logLevel.getLevel().name();
    }
}
