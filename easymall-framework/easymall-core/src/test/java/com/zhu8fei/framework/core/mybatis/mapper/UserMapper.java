package com.zhu8fei.framework.core.mybatis.mapper;

import com.zhu8fei.framework.core.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Delete({
            "delete from u_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

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

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(User record);

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

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
            "update u_user",
            "set name = #{name,jdbcType=VARCHAR},",
            "real_name = #{realName,jdbcType=VARCHAR},",
            "email = #{email,jdbcType=VARCHAR},",
            "mobile = #{mobile,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "salt = #{salt,jdbcType=VARCHAR},",
            "is_delete = #{isDelete,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=DATE},",
            "create_user = #{createUser,jdbcType=BIGINT},",
            "create_user_name = #{createUserName,jdbcType=VARCHAR},",
            "modify_time = #{modifyTime,jdbcType=DATE},",
            "modify_user = #{modifyUser,jdbcType=BIGINT},",
            "modify_user_name = #{modifyUserName,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}