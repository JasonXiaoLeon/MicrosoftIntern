package com.microsoft.week4.demoProj.Service;

import com.microsoft.week4.demoProj.Entity.User;
import com.microsoft.week4.demoProj.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateById(user);
    }
}
