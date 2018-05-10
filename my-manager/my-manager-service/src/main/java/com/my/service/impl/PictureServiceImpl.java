package com.my.service.impl;

import com.my.service.PictureService;
import com.my.utils.FtpUtil;
import com.my.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PictureServiceImpl implements PictureService {
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map uploadPicture(MultipartFile multipartFile) {
        Map<String, String> resultMap = new HashMap<>();
        try {
            //原始文件名
            String oldName = multipartFile.getOriginalFilename();
            //生成一个新的文件名
//        String newName = String.valueOf(UUID.randomUUID());
            String newName = IDUtils.genImageName() + oldName.substring(oldName.lastIndexOf("."));
            //图片上传
            String filePath = new DateTime().toString("/yyyy/mm/dd");

            Boolean ok = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newName, multipartFile.getInputStream());
            if (!ok) {
                resultMap.put("error", "1");
                resultMap.put("message", "文件上传失败");
            }
            if (ok) {
                resultMap.put("error", "0");
                resultMap.put("url", IMAGE_BASE_URL + filePath + "/" + newName);
            }

        } catch (IOException e) {
            resultMap.put("error", "1");
            resultMap.put("message", "文件上传时发生异常");
            return resultMap;
        }
        return resultMap;

    }
}
