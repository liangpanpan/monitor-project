package com.qs.monitor.controller;

import com.qs.monitor.entity.User;
import com.qs.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/19       create this file
 * </pre>
 */
@RestController
@RequestMapping(value = "/api/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public User login(HttpServletRequest request, String userName, String password) {
        User user = userService.findUserByAccountAndPassword(userName, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", user.getId());
            redisTemplate.opsForValue().set("loginUser:" + user.getId(), session.getId());

            return user;
        } else {
            throw new RuntimeException("账户名或密码错误！");
        }
    }

    @RequestMapping(value = "/getUserInfo")
    public User get(Integer userId) {
        User user = userService.selectUser(userId);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("用户不存在！");
        }
    }
}
