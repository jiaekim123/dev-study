package com.study.devstudy.spring.loglevel;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class CustomLogger {
    Logger logger = LogManager.getRootLogger();

    /**
     * 이제 setLevel을 지원하지 않는다.
     * https://stackoverflow.com/questions/4598702/dynamically-changing-log4j-log-level
     */
    public CustomLogger(Level level) {
//        logger.setLevel(level);
    }

    public void logging(){
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
    }

    public void info(String message){
        logger.info(message);
    }

    public Level getLevel() {
        return logger.getLevel();
    }
}
