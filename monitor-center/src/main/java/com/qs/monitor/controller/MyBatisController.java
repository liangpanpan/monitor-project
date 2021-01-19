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
    public User selectEmp(@RequestParam Integer id) {
        return userService.selectUser(id);
    }

    @RequestMapping(value = "/insertEmp")
    public List<User> insertEmp(User emp) {
        int result = userService.insertUser(emp);
        if (result != 1) {
            throw new RuntimeException("插入数据“" + emp.getUserName() + "”失败");
        }
        return userService.selectUserByName(emp.getUserName());
    }

    @RequestMapping(value = "/updateEmp")
    public User updateEmp(@RequestBody User emp) {
        int result = userService.updateUser(emp);
        if (result != 1) {
            throw new RuntimeException("修改数据id:" + emp.getId() + " userName:" + emp.getUserName() + "失败");
        }
        return userService.selectUser(emp.getId());
    }

    @RequestMapping(value = "/deleteEmp")
    public Integer deleteEmp(@RequestBody User emp) {
        return userService.deleteUser(emp);
    }

}
