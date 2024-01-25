package com.Indeed.Controller;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Service.IndeedService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/indeed")
@Slf4j
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
}
