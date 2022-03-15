package com.dy.wind.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dy.wind.entity.DyUser;

/**
 * @author Hasee
 */
public interface DyUserService extends IService<DyUser> {

    boolean insertUser(DyUser dyUser);

    boolean loginUser(String username, String password);
}
