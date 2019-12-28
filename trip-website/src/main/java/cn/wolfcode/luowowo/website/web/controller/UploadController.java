package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.website.web.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @Value("${file.path}")
    private String filePath;

    @RequestMapping("/coverImageUpload")
    @ResponseBody
    public Object uploadImg(MultipartFile pic){
        String filename = UploadUtil.upload(pic, filePath);
        return filename;
    }


}
