package com.study.devstudy.spring.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2022/04/20
 */
@Slf4j
@Configuration
public class WarmupTestConfig {

    @EventListener(ApplicationReadyEvent.class)
    public void warmup(){
        log.info("[ApplicationReadyEvent] WarmUp!!!!!");
    }
}
