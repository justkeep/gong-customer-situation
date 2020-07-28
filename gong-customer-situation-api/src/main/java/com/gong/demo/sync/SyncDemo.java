package com.gong.demo.sync;

import com.gong.vo.User;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncDemo {
    static User user = new User();

    public static void main(String[] args) {

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        System.out.println("读锁");
        readLock.unlock();
//        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
//        writeLock.lock();
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }
}
