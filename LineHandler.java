package com.pt.reactor.container;

import java.util.List;

/**
 * @author nate-pt
 * @date 2022/7/15 11:23
 * @Since 1.8
 * @Description 队列处理
 */
public interface LineHandler<T> {

    /**
     * 排队队列
     * @return
     */
    List<T> search(String key,Class<T> tClass);

    /**
     * 下一位
     * @param key
     */
    void callNext(String key,Class<T> tClass);

    /**
     * 特呼
     * @param key
     * @param t
     */
    void callAge(String key,T t,Class<T> tClass);
}
