package com.my.portal.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String skipIndex() {
        return "index";
    }


    @RequestMapping(value = "/httpclient/post",method = RequestMethod.POST)
    @ResponseBody
    public String doPost(){
        return "<- hello! ->";
    }


    @RequestMapping(value = "/httpclient/postWithParam",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String doPostWithParam(String name,String password) {
        System.out.println(name);
        return "name:" + name + "\tpassword" + password;
    }


}
