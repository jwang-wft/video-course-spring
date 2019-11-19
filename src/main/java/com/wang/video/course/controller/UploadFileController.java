package com.wang.video.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wang.video.course.filestorage.FileStorage;

@Controller
public class UploadFileController {
	
	@Autowired
	FileStorage fileStorage;
	
    @PostMapping("/files/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			fileStorage.store(file);
			model.addAttribute("message", "File uploaded successfully! -> filename = " + file.getOriginalFilename());
		} catch (Exception e) {
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
        return "multipartfile/uploadform.html";
    }
    
    
}
