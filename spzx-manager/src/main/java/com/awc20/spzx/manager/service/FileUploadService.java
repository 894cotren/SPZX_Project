package com.awc20.spzx.manager.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String fileUpload(MultipartFile multipartFile);
}
