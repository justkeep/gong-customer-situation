package com.gong.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/2/002.
 */
@Aspect
@Component
public class LoginAspect {
    @Around(value = "execution(* com.gong.customer.situation.service.LoginService.login(..))")
    public Object loginAspect(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        String userId = (String)args[0];
        System.out.println(userId+"开始登录");
        Object result = jp.proceed();
        System.out.println(userId+"登录结束");
        return result;
    }

    @AfterReturning(value = "execution(* com.gong.customer.situation.service.LoginService.isLegal(..))",returning = "result")
    public void iLegalUserAspect(JoinPoint joinPoint,Object result){
        if (!(boolean)result){
            Object[] args = joinPoint.getArgs();
            String userId = (String)args[0];
            System.out.println("增加非法用户"+userId+"登录的次数");
        }
    }

}
