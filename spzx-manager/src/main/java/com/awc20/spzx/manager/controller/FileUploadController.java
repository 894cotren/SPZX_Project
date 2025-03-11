package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.FileUploadService;
import com.awc20.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/system")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService ;

    @PostMapping(value = "/fileUpload")
    public Result<String> fileUploadService(@RequestParam(value = "file") MultipartFile multipartFile) {
        String fileUrl = fileUploadService.fileUpload(multipartFile) ;
        return Result.ok(fileUrl);
    }

}