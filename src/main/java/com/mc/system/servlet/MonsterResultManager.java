package com.mc.system.servlet;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mc.common.MonsterContants;

import java.io.Serializable;

/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/03 16:50
 * @since v1.0
 */
public class MonsterResultManager<T> implements Serializable{
    private Code code;
    private String message;
    private T data;

    public enum Code {
        SUCCESS, FAIL
    }
    public MonsterResultManager() {
        super();
    }

    public MonsterResultManager(Code code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> MonsterResultManager<T> newSuccess(T data) {
        if (data.getClass().getTypeName().equals(MonsterContants.MONSTER_RESULT)) {
            return (MonsterResultManager<T>)data;
        }
        return new MonsterResultManager(Code.SUCCESS, "", data);
    }

    public static <T> MonsterResultManager<T> newFailed(String message, T data) {
        return new MonsterResultManager(Code.FAIL, message, data);
    }

    public static MonsterResultManager newFailed(String message) {
        return new MonsterResultManager(Code.FAIL, message, null);
    }

    @JsonIgnore
    @JSONField(serialize = false)
    public boolean isSuccess() {
        return Code.SUCCESS.equals(this.code);
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
