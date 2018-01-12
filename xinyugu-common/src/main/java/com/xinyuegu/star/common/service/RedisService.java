package com.xinyuegu.star.common.service;

import java.util.List;

/**
 * Created by coffice on 2017/11/25.
 */

public interface RedisService {

    public boolean delete(String key);
    public boolean set(String key, String value);

    public String get(String key);

    public boolean expire(String key, long expire);

    public <T> boolean setList(String key, List<T> list);

    public <T> List<T> getList(String key, Class<T> clz);

    public <T> boolean setEntity(String key, Object obj);

    public <T> T getEntity(String key, Class<T> clz);

    public long lpush(String key, Object obj);

    public long rpush(String key, Object obj);

    public String lpop(String key);
}
