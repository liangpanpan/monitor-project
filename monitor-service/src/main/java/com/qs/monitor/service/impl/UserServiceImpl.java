package com.qs.monitor.service.impl;

import com.qs.monitor.entity.User;
import com.qs.monitor.entity.UserExample;
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
    public User selectUser(Double id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findUserByAccountAndPassword(String userName, String password) {

        List<User> userList = searchUserByNameFromExample(userName);
        User user = null;
        if (userList != null) {
            user =
                    userList.stream().filter(searchUser -> password.equals(searchUser.getPassword())).findAny().orElse(null
                    );
        }
        return user;
    }

    @Override
    public List<User> selectUserByName(String userName) {
        return searchUserByNameFromExample(userName);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return userMapper.deleteByPrimaryKey(user.getId());
    }


    /**
     * 通过姓名查找符合条件的所有用户
     * @param userName
     * @return
     */
    private List<User> searchUserByNameFromExample(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        return userMapper.selectByExample(userExample);
    }

}
