package com.zhu8fei.framework.common.mybatis.plugin;

import com.zhu8fei.framework.common.mybatis.DataResourceConfig;
import com.zhu8fei.framework.common.mybatis.config.MybatisConfig;
import com.zhu8fei.framework.common.mybatis.mapper.UserMapper;
import com.zhu8fei.framework.common.mybatis.model.User;
import com.zhu8fei.framework.test.commons.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * Created by zhu8fei on 2017/3/28.
 */
@ContextConfiguration(classes = {MybatisConfig.class, DataResourceConfig.class})
public class InsertSqlPluginTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(InsertSqlPluginTest.class);
    @Autowired
    UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("test");
        user.setRealName("last");
        user.setEmail("zxx@zz.com");
        user.setMobile("13100912233");
        user.setPassword("123");
        user.setSalt("321");
        userMapper.insert(user);

        User result = userMapper.selectByPrimaryKey(user.getId());
        logger.info(result.getName());
        logger.info(result.getEmail());
    }

    @Test
    public void select() {
        User user = new User();
        user.setId(1L);
        User result = userMapper.selectByPrimaryKey(user.getId());
        logger.info(result.getName());
        logger.info(result.getEmail());
        assertNotNull(result);
    }
}