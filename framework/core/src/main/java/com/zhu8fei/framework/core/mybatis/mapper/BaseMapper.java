package com.zhu8fei.framework.core.mybatis.mapper;

import com.zhu8fei.framework.core.mybatis.model.BaseEntity;

import java.util.List;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public interface BaseMapper<T extends BaseEntity> {
    int insert(T t);

    int update(T t);

    int delete(T t);

    List<T> select(T t);
}
