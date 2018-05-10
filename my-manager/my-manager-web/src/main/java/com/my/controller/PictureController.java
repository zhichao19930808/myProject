package com.my.controller;

import com.my.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(MultipartFile uploadFile) throws Exception {
        //调用service上传图片,返回上传结果并回显
        Map resultMap = pictureService.uploadPicture(uploadFile);
        System.out.println(resultMap.get("error"));
        System.out.println(resultMap.get("url"));
        return resultMap;
    }
}
