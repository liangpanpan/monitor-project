package com.qs.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/12       create this file
 * </pre>
 */
@Controller
@RequestMapping("/html")
public class HtmlController {

    @GetMapping(value = "/intoIndexHtml")
    public String intoIndex() {
        return "index";
    }
}
