package com.gong.demo.producerAndconsumer.demo1;


import java.util.Vector;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private Vector<Integer> pool;
    private Integer size;

    public Producer(Vector<Integer> pool,Integer size){
        this.pool = pool;
        this.size = size;
    }
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("生产一个商品");
                produce(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws Exception{
        while (pool.size() == size){
            synchronized (pool) {
                System.out.println("生产者等待消费者消费商品,当前商品数量为" + pool.size());
                pool.wait();//等待消费者消费
            }
        }
        synchronized (pool){
            pool.add(i);
            pool.notifyAll();  //通知消费者消费商品
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        Producer producer = new Producer(vector,10);
        Consumer consumer = new Consumer(vector);
        new Thread(producer).start();
//        new Thread(producer).start();
//
//        new Thread(consumer).start();
        new Thread(consumer).start();
    }

}
