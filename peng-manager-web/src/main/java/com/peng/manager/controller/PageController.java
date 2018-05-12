package com.peng.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转 Controller
 *
 * @author renyapeng
 * @date 2018/05/10
 */
@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
