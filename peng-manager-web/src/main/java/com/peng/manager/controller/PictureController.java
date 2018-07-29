package com.peng.manager.controller;

import com.peng.common.utils.FastDFSClient;
import com.peng.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传处理 Controller
 *
 * @author renyapeng
 * @date 2018/06/19
 */
@Controller
public class PictureController {

    @Value("${image.server.url}")
    private String imageServerURL;

    @RequestMapping(value = "/pic/upload", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) {
        try {
            // 1.取文件的原始文件名
            String originalFilename = uploadFile.getOriginalFilename();
            // 2.截取扩展名
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 3.创建一个 FastDFSClient 对象
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            // 4.实现文件的上传
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            // 5.服务端返回一个路径和文件名，需要拼接成一个完整的url
            url = imageServerURL + url;
            // 6.创建一个Map对象，设置属性
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            // 7.返回map
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            // 6.创建一个Map对象，设置属性
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "文件上传失败");
            return JsonUtils.objectToJson(result);
        }
    }
}