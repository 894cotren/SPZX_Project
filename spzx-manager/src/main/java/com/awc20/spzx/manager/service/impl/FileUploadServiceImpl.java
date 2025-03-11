package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.service.FileUploadService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    @SneakyThrows
    public String fileUpload(MultipartFile multipartFile) {


        // 客户端
        MinioClient minioClient =  MinioClient.builder()
                .endpoint("http://192.168.83.123:9001")
                .credentials("admin","admin123456")
                .build();

        // 参数
        String originalFilename = multipartFile.getOriginalFilename();
        String timeStr = new DateTime().toString("/yyyy/MM/dd/");
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket("spzx-1")
                .stream(multipartFile.getInputStream(), multipartFile.getSize(), -1)
                .object("avatar"+timeStr+originalFilename)
                .build();

        // 上传
        minioClient.putObject(putObjectArgs);

        // url

        String url = "http://192.168.83.123:9001/"+"spzx-1"+"/"+"avatar"+timeStr+originalFilename;

        return url;

    }
}
