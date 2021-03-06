package com.study.devstudy.spring.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2022/04/20
 */

@Slf4j
@Component
public class CommandLineRunnerTest2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("[CommandLineRunner] Test2");
    }
}
