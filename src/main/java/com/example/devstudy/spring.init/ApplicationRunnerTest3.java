package com.example.springinit;

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
public class ApplicationRunnerTest3 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread.sleep(1000);
        log.info("[ApplicationRunner] Test3");
    }
}
