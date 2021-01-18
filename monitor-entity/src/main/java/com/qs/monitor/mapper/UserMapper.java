package com.qs.monitor.mapper;

import com.qs.monitor.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface UserMapper {

    User selectUser(Integer id);

    List<User> selectUserByName(String userName);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(User user);
}