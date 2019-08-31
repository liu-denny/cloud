package com.example.userservice.dao;

import com.example.userservice.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yudong
 * @create 2019-08-28 20:47
 */
@Mapper
public interface UserDao {
    @Select("SELECT id,username,password FROM `user`")
    List<User> findAll();

    @Select("SELECT id,username,password FROM `user` where id = #{id}")
    User findOne(@Param("id")String id);

    @Update("UPDATE `user` SET username = #{userName},`password` = #{password} where id = #{id}")
    Integer update(@Param("id")String id,@Param("userName")String userName,@Param("password")String password);

    @Delete("DELETE FROM `user` WHERE username = #{username}")
    Integer delete(@Param("username")String username);

    @Insert("INSERT INTO `user` (id,username,password) VALUES (#{id},#{username},#{password});")
    Integer save(@Param("id")String id,@Param("username")String username,@Param("password")String password);

}
