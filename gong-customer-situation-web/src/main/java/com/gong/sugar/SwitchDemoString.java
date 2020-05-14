package com.gong.sugar;

/**
 * switch 支持 String 与枚举
 * @author gyk
 * @date 2019/6/20/020
 */
public class SwitchDemoString {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }
    }
}
