package com.mc.mapper;

import com.mc.vo.MonsterQuartzVo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/07 10:36
 * @since v1.0
 */

@Repository
public interface MonsterQuartzMapper {
    default List<MonsterQuartzVo> selectJobs(MonsterQuartzVo mqv) {
        return new ArrayList<MonsterQuartzVo>();
    }
}
