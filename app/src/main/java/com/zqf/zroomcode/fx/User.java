package com.zqf.zroomcode.fx;

/**
 * Author: zqf
 * Date: 2022/05/16
 */
class User<T> {

    private final T name;

    public User(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }
}
