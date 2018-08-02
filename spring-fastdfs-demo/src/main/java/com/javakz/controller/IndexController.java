package com.javakz.controller;

import com.google.gson.Gson;
import com.javakz.model.ResponseData;
import com.javakz.utils.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 *  .--,       .--,
 * ( (  \.---./  ) )
 *  '.__/o   o\__.'
 *     {=  ^  =}
 *      >  -  <
 *     /       \
 *    //       \\
 *   //|   .   |\\
 *   "'\       /'"_.-~^`'-.
 *      \  _  /--'         `
 *    ___)( )(___
 *   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * @Author: yandq
 * @Description: 
 * @Date: Create in 17:00 2018/8/2
 * @Modified By: 
 */
@RestController
public class IndexController {

    private final static Logger LOG = LoggerFactory.getLogger(IndexController.class);

    /** 文件服务器地址 **/
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @RequestMapping(value = "/demo")
    public String demo() {
        return "demo：例子";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("fileInfo") MultipartFile file) {

        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:context/fdfs-client.conf");
            // 执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            // 拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL +":8888/"+ path;
            return new Gson().toJson(new ResponseData("0000",url));
        } catch (Exception e) {
            LOG.error("上传图片失败：", e);
            return new Gson().toJson(new ResponseData("9999", "上传失败"));
        }
    }
}
