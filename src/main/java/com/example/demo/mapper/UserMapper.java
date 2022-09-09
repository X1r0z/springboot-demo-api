package com.example.demo.mapper;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUser(User user);
    User selectUserByName(String username);
    int insertUser(User user);
}
