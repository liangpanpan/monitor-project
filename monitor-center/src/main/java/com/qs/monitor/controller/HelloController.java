package com.qs.monitor.controller;

import com.qs.monitor.common.annotation.Authorization;
import com.qs.monitor.common.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/8       create this file
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/hello")
@Authorization
@ResponseResult
public class HelloController {

    // 注入对象
    @Autowired
    private Environment env;

    // 注入配置
    @Value("${server.info}")
    private String info;

    @GetMapping("/getPort/{id}")
    public String getPort(@PathVariable String id) {

        String port = env.getProperty("server.info");

        if ("1".equals(id)) {
            throw new RuntimeException("输入错误");
        }
        return port;
    }


    // @RequestMapping(value = "/hello", produces = "application/json;charset=utf-8")
    // @PostMapping(value = "/hello")
    @GetMapping(value = "/sayHello")
    @ResponseBody  // 添加该信息可以返回JSON对象
    public String hello() {
        String serverInfo = env.getProperty("server.info");
        log.info("get server.info from env :" + serverInfo);
        return "梁盼盼" + info + "  getServerInfo:" + serverInfo;
    }


    @GetMapping(value = "/intoIndex")
    public String intoIndex() {
        return "index";
    }

}
