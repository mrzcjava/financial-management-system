package com.main.mapper;

import com.main.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User queryUserById(String username);

    int addNewUser(User user);
}
