package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {
    /*
     去到首页，默认地址
     */
    @RequestMapping("/")
    public String skipToIndex() {
        return "index";
    }

    /*
    去到其他页面
     */
    @RequestMapping("/{page}")
    public String skipToPage(@PathVariable String page) {
        return page;
    }


}
