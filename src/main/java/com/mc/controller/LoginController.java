package com.mc.controller;

import com.mc.system.servlet.MonsterServletUtils;
import com.mc.vo.LoginVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 注册/登录的controller
 * @author ChenglongChu
 * @create 2017/08/01 17:17
 * @since v1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController extends MonsterBaseController {
    /**
     * user login system business.
     * @param request
     * @param response
     * @author ChenglongChu
     * @create 2017/08/01 17:17
     */
    @RequestMapping(value="/checkLogin.do", method = { RequestMethod.POST})
    public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
        LoginVo loginVo = MonsterServletUtils.input(request, LoginVo.class);
        loginService.checkUsernameAndPassword(loginVo);
        MonsterServletUtils.output(response, loginVo.getUsername());
    }


}
