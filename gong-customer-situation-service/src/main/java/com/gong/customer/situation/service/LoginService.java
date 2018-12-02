package com.gong.customer.situation.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/12/2/002.
 */
@Service
public class LoginService {
    public void login(String userId){
        //避免Aop失效
        LoginService currentProxy = (LoginService) AopContext.currentProxy();
        if (currentProxy.isLegal(userId)){
            System.out.println(userId+"正常登录");
            return;
        }
        System.out.println(userId+"非法用户");
    }
    public boolean isLegal(String userId){
        return !"user_1".equalsIgnoreCase(userId);
    }
}
