package com.imooc.cache;

import com.imooc.util.JedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * @Auther: taoxd
 * @Date: 2019/4/24 14:59
 * @Description:
 */
@Component
public class RedisCache<k, v> implements Cache<k, v> {

    @Resource
    private JedisUtil jedisUtil;

    private final String CACHE_PREFIX = "imooc-cache:";

    private byte[] getKey(k k) {
        System.out.println("从redis获取权限数据");
        if (k instanceof String) {
            return (CACHE_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    public v get(k k) throws CacheException {
        byte[] value = jedisUtil.get(getKey(k));
        if (value != null) {
            return (v) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public v put(k k, v v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtil.set(key, value);
        jedisUtil.expire(key, 600);
        return v;
    }

    public v remove(k k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = jedisUtil.get(key);
        jedisUtil.del(key);
        if (value != null) {
            return (v) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public void clear() throws CacheException {

    }

    public int size() {
        return 0;
    }

    public Set<k> keys() {
        return null;
    }

    public Collection<v> values() {
        return null;
    }
}
