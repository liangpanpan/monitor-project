package com.qs.monitor.service;

import com.qs.monitor.entity.User;

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
public interface UserService {
    User selectUser(Integer id);

    User findUserByAccountAndPassword(String userName, String password);

    List<User> selectUserByName(String userName);

    Integer insertUser(User emp);

    Integer updateUser(User emp);

    Integer deleteUser(User emp);
}
