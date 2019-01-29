package com.gong.controller;

import com.gong.pojo.CheckedException;
import com.gong.pojo.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 59448 on 2017/9/6.
 */
@Aspect
@Component
public class ControllerAOP {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    /*@Pointcut("execution(com.gyk.study.pojo.ResultBean *(..))")
    public void resultBeanPoint(){}*/

    @Around("execution(com.gyk.study.pojo.ResultBean *(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp){
        long startTime = System.currentTimeMillis();
        ResultBean<?> result;
        try {
            result = (ResultBean<?>)pjp.proceed();
            logger.info(pjp.getSignature() +"use time" +(System.currentTimeMillis()-startTime));
        } catch (Throwable e) {
            result = handlerException(pjp,e);
        }
        return result;
    }

    public ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e){
        ResultBean<?> result = new ResultBean();
        //已知异常
        if(e instanceof CheckedException){
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        }else{
            logger.error(pjp.getSignature()+"error",e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
        }
        return result;
    }
}
