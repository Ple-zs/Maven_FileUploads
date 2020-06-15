package com.file.test;

public class Test {
    public static void main(String[] args) {
        String str = "123456.jpg";
        String newStr = str.substring(str.indexOf("."));
        System.out.println(newStr);
    }
}
