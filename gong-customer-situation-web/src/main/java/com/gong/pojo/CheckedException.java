package com.gong.pojo;

/**
 * Created by 59448 on 2017/9/8.
 */
public class CheckedException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public void CheckedException(){
    }
    public CheckedException(String message){
        super(message);
    }
    public CheckedException(Throwable cause){
        super(cause);
    }
    public CheckedException(String message, Throwable cause){
        super(message,cause);
    }
    public CheckedException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
