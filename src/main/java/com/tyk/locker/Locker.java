package com.tyk.locker;

/**
 * @Author: tyk
 * @Date: 2020/3/24 11:22
 * @Description:
 */
public interface Locker {
    void lock(String key, Runnable command);
}
