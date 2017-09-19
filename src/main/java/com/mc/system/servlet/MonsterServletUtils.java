package com.mc.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.mc.common.MonsterContants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/22 15:56
 * @since v1.0
 */
public class MonsterServletUtils {

    public static <T> T  input(HttpServletRequest request, Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String attrName = field.getName();

            String getMethedName = MonsterContants.GET + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);
            String setMethedName = MonsterContants.SET + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);

            Method getMethed = clazz.getMethod(getMethedName);
            Method setMethod = null;

            Type type = getMethed.getGenericReturnType();
//                System.out.println(type.getTypeName());
            Class<? extends Object> setClass = null;
            if (type instanceof ParameterizedType) {
                String typeName = type.getTypeName();
                setClass = Class.forName(typeName.substring(0, typeName.indexOf("<")));
            } else {
                if (MonsterContants.INT.equals(type.getTypeName())) {
                    setClass = int.class;
                } else if (MonsterContants.DOUBLE.equals(type.getTypeName())) {
                    setClass = double.class;
                } else if (MonsterContants.FLOAT.equals(type.getTypeName())) {
                    setClass = float.class;
                } else if (MonsterContants.BOOLEAN.equals(type.getTypeName())) {
                    setClass = boolean.class;
                } else if (MonsterContants.CHAR.equals(type.getTypeName())) {
                    setClass = char.class;
                } else if (MonsterContants.SHORT.equals(type.getTypeName())) {
                    setClass = short.class;
                } else if (MonsterContants.BYTE.equals(type.getTypeName())) {
                    setClass = byte.class;
                } else if (MonsterContants.LONG.equals(type.getTypeName())) {
                    setClass = long.class;
                } else {
                    setClass = Class.forName(type.getTypeName());
                }
            }

            setMethod = clazz.getMethod(setMethedName, setClass);
            Object value = request.getParameter(attrName);
            setMethod.invoke(t, value);
//                System.out.println(clazz.getMethod(getMethedName).invoke(t));
        }

        return t;
    }


    public static void output(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        //ajax dynamic init
        response.setHeader("Cache-Control", "no-cache");
        //to json string
        String json = JSONObject.toJSONStringWithDateFormat(MonsterResultManager.newSuccess(obj), MonsterContants.DATE_FORMAT_ONE);
        //output response
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    public static <T> Map<String, Object> objectToHashMap(T t) throws Exception {
        Map<String, Object> map = new HashMap<>();

        Class<? extends Object> clazz = t.getClass();
        //获取属性集合
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取属性名
            String attrName = field.getName();
            //获取get方法名
            String getMethedName = "get" + attrName.substring(0, 1).toUpperCase()+ attrName.substring(1);
            //拿到get方法
            Method getMethod = clazz.getMethod(getMethedName);
//            System.out.println(attrName + ":" + getMethod.invoke(t));
            //通过get方法获取属性值放入map中
            map.put(attrName, getMethod.invoke(t));
        }

        return map;
    }

}
