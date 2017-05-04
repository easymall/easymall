package com.zhu8fei.framework.core.mybatis.mapper;

import java.util.List;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public interface BaseMapper<T> {
    int insert(T user);

    int update(T user);

    int delete(T user);

    List<T> select(T t);
}
