package com.microsoft.week4.demoProj.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microsoft.week4.demoProj.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}