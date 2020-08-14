package com.learninspringboot.ecofootprintapi.controller;

import com.learninspringboot.ecofootprintapi.model.Photo;
import com.learninspringboot.ecofootprintapi.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/photos")
@CrossOrigin(origins = "http://localhost:8080")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("file") MultipartFile file, Model model) throws IOException {
        String id = photoService.addPhoto(title, file);
        return id;
    }

    @GetMapping("/{id}")
    public String getPhoto(@PathVariable String id, Model model) throws Exception {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("url", "/photos/stream/" + id);
        return "photos";
    }

    @GetMapping("/stream/{id}")
    public void streamPhoto(@PathVariable String id, HttpServletResponse response) throws Exception {
        Photo photo = photoService.getPhoto(id);
        if (photo == null) {
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
        } else {
            FileCopyUtils.copy(photo.getStream(), response.getOutputStream());
        }
    }
}
