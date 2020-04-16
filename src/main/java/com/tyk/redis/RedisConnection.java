package com.tyk.redis;

import redis.clients.jedis.Jedis;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: tyk
 * @Date: 2020/4/10 12:16
 * @Description:
 */
public class RedisConnection {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
////        System.out.println("服务正在运行："+ jedis.ping());
//        jedis.select(3);
//        jedis.set("redis:name", "tyk");
//        System.out.println("存储的字符串为：" + jedis.get("redis:name"));
//
//        String s = jedis.hget("CACHED_ALL_TREECARVO_MAP", "1926");
//        byte[] bytes = s.getBytes(StandardCharsets.UTF_16);
//        setObject();
//        Person person = getObject(100);
        getObject2();
    }

    public static void setObject() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.select(2);
        Person person = new Person(100, "alan");
        jedis.set("person:100".getBytes(), SerializeUtil.serialize(person));
        person = new Person(101, "bruce");
        jedis.set("person:101".getBytes(), SerializeUtil.serialize(person));
    }

    public static Person getObject(int id) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.select(2);
        byte[] person = jedis.get(("person:" + id).getBytes());
        return (Person) SerializeUtil.unserialize(person);
    }
    public static CarInfoEntity getObject2() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.select(3);
        byte[] car = jedis.get(("CACHED_ALL_TREECARVO_MAP").getBytes());
        return (CarInfoEntity) SerializeUtil.unserialize(car);
    }


}