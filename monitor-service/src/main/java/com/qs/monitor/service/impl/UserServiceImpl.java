package com.qs.monitor.service.impl;

import com.qs.monitor.entity.User;
import com.qs.monitor.mapper.UserMapper;
import com.qs.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/18       create this file
 * </pre>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(Integer id) {
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> selectUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    public Integer insertUser(User emp) {
        return userMapper.insertUser(emp);
    }

    @Override
    public Integer updateUser(User emp) {
        return userMapper.updateUser(emp);
    }

    @Override
    public Integer deleteUser(User emp) {
        return userMapper.deleteUser(emp);
    }
}
