package com.gong.customer.situation.utils;/*
 * 四川生学教育科技有限公司
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author yuke.gong
 * @description 线程池工具
 * @slogon
 * @since 1.0.0
 */
public class MyThreadPoolExecutor {

    private ThreadPoolExecutor executorService;

    private MyThreadPoolExecutor(int maxThreadPoolSize) {
        executorService=new ThreadPoolExecutor(maxThreadPoolSize, maxThreadPoolSize,
                60, TimeUnit.MILLISECONDS,
                new SynchronousQueue(),new MyRejectedExecutionHandler());
    }
    private class MyRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if(!executor.isShutdown()){
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    throw new RejectedExecutionException(e);
                }
            }
        }
    }

    public static MyThreadPoolExecutor open(int maxThreadPoolSize){
        return new MyThreadPoolExecutor(maxThreadPoolSize);
    }
    public void execute(Runnable runnable){
        executorService.execute(runnable);
    }

//    private MyThreadPoolExecutor(int corePoolSize,int maxPoolSize) {
//        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        executorService=new ThreadPoolExecutor(corePoolSize, maxPoolSize,60, TimeUnit.MILLISECONDS,
//                new LinkedBlockingDeque<Runnable>(200),new ThreadPoolExecutor.AbortPolicy());
//        executorService.execute(()-> System.out.println("业务执行部分"));
//        //优雅的关闭
//        executorService.shutdown();
//    }

}
