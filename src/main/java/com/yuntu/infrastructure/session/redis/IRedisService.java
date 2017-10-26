package com.yuntu.infrastructure.session.redis;

import java.util.List;

/**
 * Created by jackdeng on 2017/10/24.
 */
public interface IRedisService {

    public void delete(String key);

    public boolean set(String key, String value);

    public String get(String key);

    public boolean expire(String key, long expire);

    public <T> boolean setList(String key, List<T> list);

    public <T> List<T> getList(String key, Class<T> clz);

    public long lpush(String key, Object obj);

    public long rpush(String key, Object obj);

    public String lpop(String key);

}
