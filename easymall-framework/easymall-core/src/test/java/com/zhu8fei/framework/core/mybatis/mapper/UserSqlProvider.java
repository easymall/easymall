package com.zhu8fei.framework.core.mybatis.mapper;

import com.zhu8fei.framework.core.mybatis.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("u_user");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.VALUES("real_name", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("is_delete", "#{isDelete,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=DATE}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUserName() != null) {
            sql.VALUES("create_user_name", "#{createUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=DATE}");
        }
        
        if (record.getModifyUser() != null) {
            sql.VALUES("modify_user", "#{modifyUser,jdbcType=BIGINT}");
        }
        
        if (record.getModifyUserName() != null) {
            sql.VALUES("modify_user_name", "#{modifyUserName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("u_user");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("is_delete = #{isDelete,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{createUser,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUserName() != null) {
            sql.SET("create_user_name = #{createUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=DATE}");
        }
        
        if (record.getModifyUser() != null) {
            sql.SET("modify_user = #{modifyUser,jdbcType=BIGINT}");
        }
        
        if (record.getModifyUserName() != null) {
            sql.SET("modify_user_name = #{modifyUserName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}