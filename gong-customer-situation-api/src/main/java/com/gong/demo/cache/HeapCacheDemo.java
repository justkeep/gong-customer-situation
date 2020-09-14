package com.gong.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java 堆下的缓存
 * 适用场景：
 * 1.少量数据
 * 2.更新频率较低
 * @author yuke.gong
 */
public class HeapCacheDemo {
    //静态变量
    private static final String CACHE_STRING = "www.baidu.com";

    //List容器，vector 线程安全
    private static final List<String> cacheList = new Vector<String>();

    private static final Map<String,Object> cacheMap = new ConcurrentHashMap<String,Object>();

    private static Cache<Object, Object> cache = CacheBuilder.newBuilder().maximumSize(2).build();

    public static void main(String[] args) {
        heapCacheWithConcurrentHashMap();
    }




    /**
     * 基于ConcurrentHashMap  实现堆内存缓存
     * 分段锁实现
     * 适合高并发下的缓存（线程安全）
     */
    public static void heapCacheWithConcurrentHashMap(){
        cacheMap.put("key1","value1");
        cacheMap.put("key2","value2");
        cacheMap.put("key3","value3");

        System.out.println("第一个值：" + cacheMap.get("key1"));
        System.out.println("第二个值：" + cacheMap.get("key2"));
        System.out.println("第三个值：" + cacheMap.get("key3"));
    }

    /**
     * 基于guava cache 实现堆内存缓存  可指定缓存的大小
     * 相较于concurrentHashMap 实现了LRU淘汰策略
     * 都是基于分段锁实现
     * 适合高并发下的缓存访问
     */
    public static void heapCacheWithGuavaCache(){
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
    }
}
