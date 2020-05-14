package com.gong.sugar;

import java.math.BigDecimal;

/**
 * 自动装箱
 * 自动将原始类型转化为封装类
 * @author gyk
 * @date 2019/6/20/020
 */
public class AutomaticPacking {
    public static void main(String[] args) {
        int i=128;
        Integer ii=i;

        System.out.println(i==ii);

//        byte a =1;
//        Byte aa = a;
//
//        boolean b = true;
//        Boolean bb = b;
//
//        float c = 0.5f;
//        Float cc =c;

        Integer a = 1000;
        Integer b = 1000;
        Integer c = 100;
        Integer d = 100;
        System.out.println("a == b is " + (a == b));
        System.out.println(("c == d is " + (c == d)));

        String s = new String("sss");
        String ss ="sss";
        System.out.println("s == ss is" + (s==ss));

        Float aaa = 0.4f;
        Float aaaa = 1F;
        Float bbb = 1-aaa;
        Float aaaaa = new BigDecimal(Float.toString(1)).subtract(new BigDecimal(Float.toString(0.6f))).floatValue();
        System.out.println(bbb);
        System.out.println("结果："+aaaaa);
    }
}
