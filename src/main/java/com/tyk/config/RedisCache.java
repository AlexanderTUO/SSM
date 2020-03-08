package com.tyk.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DigestUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {
    //slf4j的日志记录器
    private static final Log logger = LogFactory.getLog(RedisCache.class);
    //缓存对象唯一标识
    private final String id; //orm的框架都是按对象的方式缓存，而每个对象都需要一个唯一标识.
    //用于事务性缓存操作的读写锁
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //处理事务性缓存中做的
    //操作数据缓存的--跟着线程走的
    public static RedisTemplate redisTemplate;  //Redis的模板负责将缓存对象写到redis服务器里面去
    //缓存对象的是失效时间，60分钟
    private static final long EXPRIRE_TIME_IN_MINUT = 60;
    //生成key
    private final String COMMON_CACHE_KEY = "com:bootdu:";

    /**
     * 所有key
     */
    private String getKeys() {
        return COMMON_CACHE_KEY + this.id + ":*";
    }

    /**
     * 按照一定规则标识key
     */
    private Object getKey(Object key) {
        return COMMON_CACHE_KEY + this.id + ":" + DigestUtils.sha1DigestAsHex(String.valueOf(key));
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.redisTemplate = redisTemplate;
    }

    //构造方法---把对象唯一标识传进来
    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存对象id是不能为空的");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    //给模板对象RedisTemplate赋值，并传出去
    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /*
     *保存缓存对象的方法
     */
    @Override
    public void putObject(Object key, Object value) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            //使用redisTemplate得到值操作对象
            ValueOperations operation = redisTemplate.opsForValue();
            //使用值操作对象operation设置缓存对象
            operation.set(getKey(key), value, EXPRIRE_TIME_IN_MINUT, TimeUnit.MINUTES);  //TimeUnit.MINUTES系统当前时间的分钟数
            logger.debug("缓存对象保存成功,key{}"+getKey(key));
        } catch (Throwable t) {
            logger.error("缓存对象保存失败" + t+","+getKey(key));
        }
    }

    /*
     *获取缓存对象的方法
     */
    @Override
    public Object getObject(Object key) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            ValueOperations operations = redisTemplate.opsForValue();
            Object result = operations.get(getKey(key));
            logger.debug("获取缓存对象"+getKey(key));
            return result;
        } catch (Throwable t) {
            logger.error("缓存对象获取失败" + t+","+getKey(key));
            return null;
        }
    }

    /*
        删除缓存对象
     */
    @Override
    public Object removeObject(Object key) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            redisTemplate.delete(getKey(key));
            logger.debug("删除缓存对象成功！"+getKey(key));
        } catch (Throwable t) {
            logger.error("删除缓存对象失败！" + t+","+getKey(key));
        }
        return null;
    }

    /*
        清空缓存对象
        当缓存的对象更新了的化，就执行此方法
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        //回调函数
        Set<String> keys = redisTemplate.keys(getKeys());
        redisTemplate.delete(keys);
        logger.debug("清空缓存对象成功！"+keys);
    }

    //可选实现的方法
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
