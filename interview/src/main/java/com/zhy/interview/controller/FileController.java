package com.zhy.interview.controller;

import com.zhy.interview.exception.BusinessException;
import com.zhy.interview.service.FileService;
import com.zhy.interview.utils.R;
import com.zhy.interview.utils.ResponseEnum;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhy
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/1119:41
 */
@RequestMapping("/api/oss/file")
//@CrossOrigin
@RestController

public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public R upload(
                    MultipartFile file,
                    String module) {
        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String upload = fileService.upload(inputStream, module, originalFilename);
            return R.ok().setData(upload);
        } catch (IOException e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR,e);
        }
    }

    @DeleteMapping("/remove")
    public R delete(
            @RequestParam("url")
                    String url) {
        fileService.removeFile(url);
        return R.ok();
    }
}




