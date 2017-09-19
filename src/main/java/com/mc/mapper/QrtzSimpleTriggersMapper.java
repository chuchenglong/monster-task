package com.mc.mapper;

import com.mc.model.QrtzSimpleTriggers;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzSimpleTriggersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_simple_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName, @Param("triggerGroup") String triggerGroup);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_simple_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int insert(QrtzSimpleTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_simple_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    QrtzSimpleTriggers selectByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName, @Param("triggerGroup") String triggerGroup);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_simple_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    List<QrtzSimpleTriggers> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_simple_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int updateByPrimaryKey(QrtzSimpleTriggers record);
}