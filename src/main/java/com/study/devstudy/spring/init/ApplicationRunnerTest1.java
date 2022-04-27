package com.study.devstudy.spring.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2022/04/20
 */
@Slf4j
@Component
public class ApplicationRunnerTest1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("[ApplicationRunner] Test1");
    }
}
