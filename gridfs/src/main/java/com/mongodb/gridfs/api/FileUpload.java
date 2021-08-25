package com.mongodb.gridfs.api;


import com.mongodb.gridfs.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUpload {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public void fileUpload(@RequestParam MultipartFile file) throws IOException {
        this.fileUploadService.uploadFile(file);
    }
}
