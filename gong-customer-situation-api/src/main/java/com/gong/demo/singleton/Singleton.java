package com.gong.demo.singleton;

/**
 * @author gongyuke
 * 单例demo
 * 懒汉模式
 * 1.使用同步锁
 * 2.使用双重检查 （Double-Check），避免创建多个对象
 * 3.使用volatile修饰禁止指令重排序(防止因为指令重排序带来的问题)
 */
public class Singleton {

    private volatile static Singleton singleton = null;

    public static Singleton getInstance(){
        //第一次 检查非null
        if (singleton == null){
            synchronized (Singleton.class){
                //第二次 检查非null
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
