package cn.tedu.img.controller;

import cn.tedu.img.service.ImgService;
import com.jt.common.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("img")
public class ImgController {

    @Autowired
    private ImgService is;

    //图片上传
    @RequestMapping("uploadImg")
    public PicUploadResult picUp(MultipartFile pic){
        System.out.println(pic);
        return is.picUp(pic);
    }


}

























