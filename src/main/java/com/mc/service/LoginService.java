package com.mc.service;

import com.mc.model.TUserInfo;
import com.mc.vo.LoginVo;
import org.springframework.stereotype.Service;


/**
 * @description
 * @author ChenglongChu
 * @create 2017/08/01 17:24
 * @since v1.0
 */
@Service
public class LoginService extends MonsterBaseService {

    public void checkUsernameAndPassword(LoginVo loginVo) throws Exception {
        TUserInfo tUserInfo = tUserInfoMapper.selectUserInfByUsername(loginVo.getUsername());
        if (!tUserInfo.getTuiPassword().equals(loginVo.getPassword())) {
            throw new Exception("password is wrong !!!");
        }
    }
}
