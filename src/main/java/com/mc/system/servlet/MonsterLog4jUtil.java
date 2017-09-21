package com.mc.system.servlet;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ChenglongChu
 * @description log4j的输出格式重组
 * @create 2017/09/19 15:07
 * @since v1.0
 */
public class MonsterLog4jUtil {
    public static void error(String message) {
        Logger logger = innerGet();
        logger.error(message);
    }

    public static void warn(String message) {
        Logger logger = innerGet();
        logger.warn(message);
    }

    public static void info(String message) {
        Logger logger = innerGet();
        logger.info(message);
    }

    public static void debug(String message) {
        Logger logger = innerGet();
        logger.debug(message);
    }

    private static Logger innerGet() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return Logger.getLogger(stackTrace[3].getClassName());
    }
}
