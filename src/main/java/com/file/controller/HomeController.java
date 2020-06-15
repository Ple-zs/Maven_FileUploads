package com.file.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/monoFile")
    public String monoFile() {
        return "loadPage/monoFile";
    }

    @RequestMapping("/multiFile_1")
    public String multiFile_1() {
        return "loadPage/multiFile_1";
    }

    @RequestMapping("/multiFile_2")
    public String multiFile_2() {
        return "loadPage/multiFile_2";
    }


    //多文件上传
    // 这里的MultipartFile[] file表示前端页面上传过来的多个文件，file对应页面中多个file类型的input标签的name，但框架只会将一个文件封装进一个MultipartFile对象，
    // 并不会将多个文件封装进一个MultipartFile[]数组，直接使用会报[Lorg.springframework.web.multipart.MultipartFile;.<init>()错误，
    // 所以需要用@RequestParam校正参数（参数名与MultipartFile对象名一致），当然也可以这么写：@RequestParam("file") MultipartFile[] files。
    @RequestMapping("multiFileUploading")
    @ResponseBody
    public void multiFile(@RequestParam("file") MultipartFile[] files,HttpServletResponse response) throws IOException {
        boolean bool = false;
        String path = "E:\\Y2\\GitHob_Idea\\maven_1\\maven_2\\src\\main\\webapp\\static\\images\\";
        if (files.length > 0) {
            File parent = new File(path);
            if (!parent.exists()) parent.mkdirs();
            //循环多次上传多个文件
            for (MultipartFile file : files) {
                //获取文件名
                String oldName = file.getOriginalFilename();
                //获取后缀
                String suffixStr = oldName.substring(oldName.indexOf("."));
                //重命名
                String filename = "Trends_" + RandomStringUtils.randomAlphanumeric(18) + "-Img" + suffixStr;
                //文件传输，parent文件
                file.transferTo(new File(path, filename));
            }
            bool = true;
        }
        response.getWriter().print(bool);
    }

    //单文件上传
    @RequestMapping("/monoFileUploading")
    @ResponseBody
    public void monoFile(@RequestParam(name = "file", required=false)MultipartFile file,HttpServletResponse response) throws IOException {
        boolean bool = false;
        String path = "E:\\Y2\\GitHob_Idea\\maven_1\\maven_2\\src\\main\\webapp\\static\\images\\";
        if(!file.isEmpty()){
            File parent = new File(path);
            if (!parent.exists()) parent.mkdirs();
            //获取文件名
            String oldName = file.getOriginalFilename();
            //获取后缀
            String suffixStr = oldName.substring(oldName.indexOf("."));
            //重命名
            String filename = "Trends_" + RandomStringUtils.randomAlphanumeric(18) + "-Img" + suffixStr;
            //文件传输，parent文件
            file.transferTo(new File(path, filename));
            bool = true;
        }
        response.getWriter().print(bool);
    }

}
