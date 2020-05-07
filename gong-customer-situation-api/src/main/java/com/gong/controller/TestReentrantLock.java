package com.gong.controller;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 ReentrantLock  公平锁和非公平锁
 */
public class TestReentrantLock {
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                System.out.println("t1-------");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                System.out.println("t2-------");
                lock.unlock();
            }
        };

        t1.start();
        t1.setName("t1");
        t2.setName("t2");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
