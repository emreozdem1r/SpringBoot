package com.mongodb.gridfs.service;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    GridFsTemplate gridFsTemplate;

    public void uploadFile(MultipartFile file) throws IOException {
        DBObject  dbObject = new BasicDBObject();   // key value tutulabilecek obje
        dbObject.put("fileName", file.getName());
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("userId", "1234");

        gridFsTemplate.store(file.getInputStream(), file.getName(), dbObject);
    }
}
