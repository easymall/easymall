package com.zhu8fei.framework.core.mybatis.mapper;

import com.zhu8fei.framework.core.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Insert({
            "insert into u_user (name, real_name, ",
            "email, mobile, password, ",
            "salt, is_delete, ",
            "create_time, create_user, ",
            "create_user_name, modify_time, ",
            "modify_user, modify_user_name)",
            "values (#{name,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
            "#{email,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{salt,jdbcType=VARCHAR}, #{isDelete,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=DATE}, #{createUser,jdbcType=BIGINT}, ",
            "#{createUserName,jdbcType=VARCHAR}, #{modifyTime,jdbcType=DATE}, ",
            "#{modifyUser,jdbcType=BIGINT}, #{modifyUserName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(User record);

    @Select({
            "select",
            "id, name, real_name, email, mobile, password, salt, is_delete, create_time, ",
            "create_user, create_user_name, modify_time, modify_user, modify_user_name",
            "from u_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
            @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
            @Result(column="create_user_name", property="createUserName", jdbcType=JdbcType.VARCHAR),
            @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.DATE),
            @Result(column="modify_user", property="modifyUser", jdbcType=JdbcType.BIGINT),
            @Result(column="modify_user_name", property="modifyUserName", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, name, real_name, email, mobile, password, salt, is_delete, create_time, ",
            "create_user, create_user_name, modify_time, modify_user, modify_user_name",
            "from u_user",
            "where real_name = #{realName,jdbcType=VARCHAR}"
    })
    @Override
    List<User> select(User user);
}