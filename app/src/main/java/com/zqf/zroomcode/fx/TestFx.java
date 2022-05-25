package com.zqf.zroomcode.fx;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zqf
 * Date: 2022/05/16
 * 泛型使用
 * TODO 泛型有三种使用方式：
 * 1、泛型类
 * 2、泛型接口
 * 3、泛型方法
 */
class TestFx {
    private static final String TAG = TestFx.class.getSimpleName();

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        Class cls1 = strList.getClass();
        Class cls2 = intList.getClass();
        System.out.println("cls1--->" + cls1);
        System.out.println("cls2--->" + cls2);
        System.out.println("cls3--->" + cls2);

        /**
         * 泛型类的使用
         */
        User user1 = new User("张三");
        User user2 = new User(20);
        System.out.println("user1--->" + user1.getName());
        System.out.println("user2--->" + user2.getName());

        /**
         * 泛型接口
         */
        PersonIml p = new PersonIml();
        System.out.println("p---" + p.name());
    }
}
