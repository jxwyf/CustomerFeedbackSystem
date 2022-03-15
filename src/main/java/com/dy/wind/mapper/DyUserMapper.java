package com.dy.wind.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dy.wind.entity.DyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * @author Hasee
 */
@Mapper
public interface DyUserMapper extends BaseMapper<DyUser> {
    int insertUser(DyUser dyUser);
    
    int loginUser(@Param("username") String username, @Param("password") String password);

    boolean selectByUsername (String username);

    Collection<DyUser> selectByUserName(String username);
}