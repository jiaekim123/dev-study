package com.study.devstudy.spring.loglevel;

import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

class LogLevelTest {
    @Test
    void 로그레벨_trace(){
        CustomLogger logger = new CustomLogger(Level.TRACE);
        logger.logging();
        logger.info(logger.getLevel().name());
    }

    @Test
    void 로그레벨_debug(){
        CustomLogger logger = new CustomLogger(Level.DEBUG);
        logger.logging();
        logger.info(logger.getLevel().name());
    }


    @Test
    void 로그레벨_info(){
        CustomLogger logger = new CustomLogger(Level.INFO);
        logger.logging();
        logger.info(logger.getLevel().name());
    }

    @Test
    void 로그레벨_warn(){
        CustomLogger logger = new CustomLogger(Level.WARN);
        logger.logging();
        logger.info(logger.getLevel().name());

    }

    @Test
    void 로그레벨_error(){
        CustomLogger logger = new CustomLogger(Level.ERROR);
        logger.logging();
        logger.info(logger.getLevel().name());

    }
}