package com.microsoft.week4.demoProj.Service;

import com.microsoft.week4.demoProj.Entity.User;


public interface UserService {
    void registerUser(User user);
    void updateUserInfo(User user);
}
