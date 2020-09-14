package com.gong.demo.producerAndconsumer.demo1;

import java.util.Vector;

public class Consumer implements Runnable {

    private Vector<Integer> pool;

    public Consumer(Vector<Integer> pool){
        this.pool = pool;
    }
    @Override
    public void run() {
        try {
            while (true){
                System.out.println("消费者消费一个商品");
                consum();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void consum() throws InterruptedException {
        synchronized (pool){
            while (pool.isEmpty()){
                System.out.println("消费者等待生产者生产商品");
                pool.wait();
            }
        }
        synchronized (pool){
            pool.remove(0);
            pool.notifyAll(); //通知生产者生产商品
        }
    }
}
