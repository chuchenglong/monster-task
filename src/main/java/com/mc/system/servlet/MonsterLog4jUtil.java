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
        info(Logger.class, message);
    }

    public static void error(Class<? extends Object> clazz, String message) {
        Logger logger = Logger.getLogger(clazz);
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = fm.format(new Date());
        logger.error(d + " - " + message);
    }

    public static void warn(String message) {
        info(Logger.class, message);
    }

    public static void warn(Class<? extends Object> clazz, String message) {
        Logger logger = Logger.getLogger(clazz);
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = fm.format(new Date());
        logger.warn(d + " - " + message);
    }

    public static void info(String message) {
        info(Logger.class, message);
    }

    public static void info(Class<? extends Object> clazz, String message) {
        Logger logger = Logger.getLogger(clazz);
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = fm.format(new Date());
        logger.info(d + " - " +message);
    }

    public static void debug(String message) {
        info(Logger.class, message);
    }

    public static void debug(Class<? extends Object> clazz, String message) {
        Logger logger = Logger.getLogger(clazz);
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = fm.format(new Date());
        logger.debug(d + " - " +message);
    }
}
