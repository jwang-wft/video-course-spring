package com.wang.video.course.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wang.video.course.entity.SourceCode;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class VideoController {
	Logger logger = LoggerFactory.getLogger(VideoController.class);
	
	@GetMapping("/videos/{name}")
	public ResponseEntity<InputStreamResource> getFullVideo(@PathVariable String name) {
		File file = new File("C:/Users/wangq/Videos/" + name);
		long contentLength = file.length();
		System.out.printf("The file size is %s\n", contentLength);
		ResponseEntity<InputStreamResource> resp = null;
		try {
			Optional<MediaType> mediaType = MediaTypeFactory.getMediaType(name);
			logger.info(String.format("The media type is %s\n", mediaType.get()));
			if (mediaType.isPresent()) {
				MediaType type = mediaType.get();
				HttpHeaders header = new HttpHeaders();
				header.setContentType(type);
				header.set("Content-Disposition", "inline;filename=" + name);
				header.setContentLength(Long.valueOf(contentLength));
				InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
				resp = ResponseEntity.ok().headers(header).body(isr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/source/{name}")
	public SourceCode getSourceCode(@PathVariable String name) {
		SourceCode source = new SourceCode(name);
		return source;
	}

}