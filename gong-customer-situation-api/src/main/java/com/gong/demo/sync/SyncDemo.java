package com.gong.demo.sync;

import com.gong.vo.User;
import org.openjdk.jol.info.ClassLayout;

public class SyncDemo {
    static User user = new User();

    public static void main(String[] args) throws InterruptedException {

        /**
         * 1.偏向锁关闭情况下，此时user 偏向标志位：0，锁标志位：01  -- 无锁状态
         * 2.偏向锁开启且无延时情况下，此时user 偏向标志位：1，锁标志位：01   --匿名偏向锁（对象头中没有存储任何线程Id）
         * 3.偏向锁开启且有延时情况下，此时user 偏向标志位：0，锁标志位：01   -- 无锁状态
         */
        System.out.println(ClassLayout.parseInstance(user).toPrintable());

        /**
         * 1.偏向锁关闭情况下，此时user 偏向标志位：0，锁标志位：00  -- 轻量锁
         * 2.偏向锁开启且无延时情况下，此时user 偏向标志位：1，锁标志位：01   --偏向锁(对象头中存储了对应的线程Id)
         * 3.偏向锁开启且有延时情况下，此时user 偏向标志位：0，锁标志位：00   -- 轻量锁
         */
        synchronized (user){
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
        synchronized (user){
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }

        /**
         *1.交替执行的情况下，1.偏向锁---->轻量锁    2.轻量锁----->轻量锁
         */
        ThreadDemo threadDemo3 = new ThreadDemo();
        threadDemo3.setName("thread-3");
        threadDemo3.start();
        Thread.sleep(5000);



        /**
         * 此时同时开启两个线程，对user进行上锁
         * 由于并发，产生了竞争
         * 此时user 偏向标志位：0，锁标志位：10   -- 此时升级为重量级锁
         */
        ThreadDemo threadDemo1 = new ThreadDemo();
        threadDemo1.setName("thread-1");
        threadDemo1.start();
        ThreadDemo threadDemo2 = new ThreadDemo();
        threadDemo2.setName("thread-2");
        threadDemo2.start();
//

    }

    public static class ThreadDemo extends Thread {
        @Override
        public void run() {
            synchronized (user){
                System.out.println(currentThread().getName()+ClassLayout.parseInstance(user).toPrintable());
            }
        }
    }
}
