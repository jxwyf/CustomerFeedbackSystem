package com.dy.wind.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dy.wind.entity.DyUser;
import com.dy.wind.mapper.DyUserMapper;
import com.dy.wind.service.DyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hasee
 */
@Service
public class DyUserServiceImpl extends ServiceImpl<DyUserMapper, DyUser> implements DyUserService {

    @Autowired
    private DyUserMapper dyUserMapper;

    @Override
    public boolean insertUser(DyUser dyUser) {
        int resultNum = dyUserMapper.insertUser(dyUser);
        return resultNum != 0;
    }

    @Override
    public boolean loginUser(String username, String password) {
        int resultNum = dyUserMapper.loginUser(username, password);
        return resultNum == 1;
    }
}
