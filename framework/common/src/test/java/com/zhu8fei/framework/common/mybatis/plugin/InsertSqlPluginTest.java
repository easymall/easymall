package com.zhu8fei.framework.common.mybatis.plugin;

import com.zhu8fei.framework.common.mybatis.example.User;
import com.zhu8fei.framework.common.mybatis.example.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zhu8fei on 2017/3/28.
 */
public class InsertSqlPluginTest extends UnitilsJUnit4 {
    @SpringApplicationContext({"application-test.xml","unitils-datasource.xml"})
    ApplicationContext context;

    @SpringBean("userMapper")
    UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
//        userMapper = context.getBean("userMapper", UserMapper.class);
    }

    @ExpectedDataSet("dataset.xls")
    @Test
    public void insert() {
        User user = new User();
        user.setName("test");
        user.setRealName("last");
        user.setEmail("zxx@zz.com");
        user.setMobile("13100112233");
        user.setPassword("123");
        user.setSalt("321");
        userMapper.insert(user);

        List<User> list = userMapper.select(user);

        System.out.println(list);
    }

    @DataSet("dataset.xls")
    @Test
    public void select() {
        User user = new User();
        List<User> list = userMapper.select(user);
        assertNotNull(list);
        assertEquals(list.size(), 1);
    }
}