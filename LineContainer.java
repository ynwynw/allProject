package com.pt.reactor.container;

import java.util.List;

/**
 * @author nate-pt
 * @date 2022/7/15 10:30
 * @Since 1.8
 * @Description
 */
public interface LineContainer<T> {


    /**
     * 从容器中拉取数据
     * @param key
     */
    List<T> pull(String key,Class<T> tClass);


    /**
     * 往容器中推送数据
     * @param list
     * @param key
     */
    void push(List<T> list,String key);


    /**
     * 异步操作
     * @param t
     */
    void async(T t);

}
