package com.mc.system.db;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description mybatis通用接口，暂不用
 * @author ChenglongChu
 * @create 2017/08/22 11:16
 * @since v1.0
 */
public interface MonsterMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // TODO
    // FIXME 特别注意，该接口不能被扫描到，否则会出错
}