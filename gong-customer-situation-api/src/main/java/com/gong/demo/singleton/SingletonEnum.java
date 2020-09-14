package com.gong.demo.singleton;

/**
 * @author gongyuke
 * 单例模式  枚举实现
 *
 */
public class SingletonEnum {
    private static SingletonEnum instance = null;

    // 私有构造函数
    private SingletonEnum(){
    }

    public static SingletonEnum getInstance(){
        return Sinleton.SINLETON.getInstance();
    }


    private enum Sinleton{
        /**
         * 单例
         */
        SINLETON;

        private SingletonEnum singleton;

        // JVM保证这个方法只调用一次
        Sinleton(){
            singleton = new SingletonEnum();
        }

        public SingletonEnum getInstance(){
            return singleton;
        }
    }
}
