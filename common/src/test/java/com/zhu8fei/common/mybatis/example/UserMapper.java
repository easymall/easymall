package com.zhu8fei.common.mybatis.example;

import java.util.List;

public interface UserMapper {

    int insert(User user);

    int update(User user);

    int delete(User user);

    List<User> select(User user);
}