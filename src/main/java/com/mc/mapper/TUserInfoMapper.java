package com.mc.mapper;

import com.mc.model.TUserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TUserInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_info
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int deleteByPrimaryKey(Integer tuiId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_info
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int insert(TUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_info
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    TUserInfo selectByPrimaryKey(Integer tuiId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_info
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    List<TUserInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_info
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int updateByPrimaryKey(TUserInfo record);

    TUserInfo selectUserInfByUsername(String username);
}