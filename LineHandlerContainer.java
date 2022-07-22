package com.pt.reactor.container;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author nate-pt
 * @date 2022/7/15 10:34
 * @Since 1.8
 * @Description
 */
public abstract  class  LineHandlerContainer<T> implements LineContainer<T> {

    private RedissonClient redissonClient = Utils.getClient();



    @Override
    public List<T> pull(String key,Class<T> tClass) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        Object o = bucket.get();
        return JSONObject.parseArray(String.valueOf(o), tClass);
    }

    @Override
    public void push(List<T> list, String key) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        String string = JSONArray.toJSONString(list);
        bucket.set(string);
    }

    @Override
    public void async(T t) {
        new Thread(()->{exec(t);}).start();
    }

    public abstract void exec(T t);
}
