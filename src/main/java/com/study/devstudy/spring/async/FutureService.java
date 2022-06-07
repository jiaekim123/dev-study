package com.study.devstudy.spring.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2022/05/19
 */
@Slf4j
@Service
public class FutureService {
    private final ExecutorService executor;

    public FutureService() {
        this.executor = Executors.newSingleThreadExecutor();
    }

    public int syncCalculateService(int input){
        log.info("{} : Starting runnable", LocalDateTime.now());
        return input * input;
    }

    public Future<Integer> asyncCalculateService(int input){
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
    public void asyncLogService(){
        executor.submit(() -> log.info("hello"));
    }

}
