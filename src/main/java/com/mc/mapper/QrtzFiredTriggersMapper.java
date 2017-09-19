package com.mc.mapper;

import com.mc.model.QrtzFiredTriggers;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzFiredTriggersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_fired_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("entryId") String entryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_fired_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int insert(QrtzFiredTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_fired_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    QrtzFiredTriggers selectByPrimaryKey(@Param("schedName") String schedName, @Param("entryId") String entryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_fired_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    List<QrtzFiredTriggers> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_fired_triggers
     *
     * @mbggenerated Fri Aug 25 10:51:35 CST 2017
     */
    int updateByPrimaryKey(QrtzFiredTriggers record);
}