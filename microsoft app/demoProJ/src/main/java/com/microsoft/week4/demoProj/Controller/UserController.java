package com.microsoft.week4.demoProj.Controller;

import com.microsoft.week4.demoProj.Entity.User;
import com.microsoft.week4.demoProj.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PutMapping("/user/{uid}")
    public void updateUserInfo(@PathVariable String uid, @RequestBody User user) {
        user.setUid(uid);
        userService.updateUserInfo(user);
    }
}
