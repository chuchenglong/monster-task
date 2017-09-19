package com.mc.utils;

import com.mc.system.servlet.MonsterLog4jUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/03 18:43
 * @since v1.0
 */
public class MonsterCommUtils {
    public static String dateToStr(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date strToDate(String date, String format) throws Exception {
        return new SimpleDateFormat(format).parse(date);
    }

    public static Date strToDateNoException(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            MonsterLog4jUtil.error(date + " format error !");
        }
        return null;
    }
}
