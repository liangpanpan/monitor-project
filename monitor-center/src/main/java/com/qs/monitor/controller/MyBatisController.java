package com.qs.monitor.controller;

import com.qs.monitor.common.annotation.ResponseResult;
import com.qs.monitor.entity.User;
import com.qs.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/9       create this file
 * </pre>
 */
@ResponseResult
@RestController
@RequestMapping(value = "/mybatis")
public class MyBatisController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectEmp")
    public User selectEmp(@RequestParam Double id) {
        return userService.selectUser(id);
    }

    @RequestMapping(value = "/insertEmp")
    public List<User> insertEmp(User user) {
        int result = userService.insertUser(user);
        if (result != 1) {
            throw new RuntimeException("插入数据“" + user.getUsername() + "”失败");
        }
        return userService.selectUserByName(user.getUsername());
    }

    @RequestMapping(value = "/updateEmp")
    public User updateEmp(@RequestBody User user) {
        int result = userService.updateUser(user);
        if (result != 1) {
            throw new RuntimeException("修改数据id:" + user.getId() + " userName:" + user.getUsername() + "失败");
        }
        return userService.selectUser(user.getId());
    }

    @RequestMapping(value = "/deleteEmp")
    public Integer deleteEmp(@RequestBody User emp) {
        return userService.deleteUser(emp);
    }

}
