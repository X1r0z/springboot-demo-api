package com.example.demo.service;

import com.example.demo.jwt.JwtUtil;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Result;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    public Result register(User user){
        if (this.userMapper.selectUserByName(user.getUsername()) == null){
            user.setIsAdmin(0);
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            return new Result(this.userMapper.insertUser(user));
        } else {
            return new Result(-1, "user has already existed");
        }
    }

    public Result login(User user){
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User resUser = this.userMapper.selectUser(user);
        if (resUser != null){
            return new Result(JwtUtil.createToken(resUser));
        } else {
            return new Result(-1, "login failed");
        }
    }
}

