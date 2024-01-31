package com.Indeed.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Service.IndeedService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/indeed")
public class IndeedController {

  private static final Logger log = LoggerFactory.getLogger(IndeedController.class);

  @Autowired IndeedService indeedService;

  @PostMapping("/post")
  public ResponseEntity<?> createPost(@Valid @RequestBody IndeedDto dto) {
    try {
      Indeed create = indeedService.createPost(dto);
      log.info("Create:{} " + create);
      return ResponseEntity.status(HttpStatus.OK).body(create);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/findAll")
  public ResponseEntity<?> getAllPosts() {
    try {
      List<Indeed> posts = indeedService.getAllPosts();
      log.info("All Posts:{} " + posts);
      return ResponseEntity.status(HttpStatus.OK).body(posts);

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
