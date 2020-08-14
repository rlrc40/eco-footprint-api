package com.learninspringboot.ecofootprintapi.service;

import com.learninspringboot.ecofootprintapi.controller.EcoFootprintController;
import com.learninspringboot.ecofootprintapi.model.Photo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {
    private static Logger LOG = LoggerFactory.getLogger(EcoFootprintController.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public String addPhoto(String title, MultipartFile file) throws IOException {
        LOG.info("ADD NEW PHOTO");
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "image");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }

    public Photo getPhoto(String id) throws IllegalStateException, IOException {
        LOG.info("GET PHOTO");
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        Photo photo = new Photo();
        if (file != null) {
            photo.setTitle(file.getMetadata().get("title").toString());
            photo.setStream(operations.getResource(file).getInputStream());
            return photo;
        }
        return null;
    }
}