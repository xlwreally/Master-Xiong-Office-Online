package com.Microsoft.日常测试;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/28 23:21
 */
public class one {
    public static void main(String[] args) {
        String password="";
        for (int i = 0; i < 5; i++) {
            int r = new java.util.Random().nextInt(26);
            r+=97;
            password = password + (char)r;
        }
        System.out.println("生成的密码是"+password);
    }
}
