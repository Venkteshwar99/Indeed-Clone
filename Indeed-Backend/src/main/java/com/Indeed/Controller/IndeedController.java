package com.Indeed.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Service.IndeedService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin
@Tag(name = "Indeed Controller",description = "Indeed Posts API's")
@RestController
@RequestMapping("/indeed")
public class IndeedController {

  private static final Logger log = LoggerFactory.getLogger(IndeedController.class);

  @Autowired IndeedService indeedService;
  
  
  /**
   * Creates a new post.
   *
   * @param IndeedDto The post to be created.
   * @return The created post.
   */
  @Operation(summary = "Create a Post", description = "Creates a new Post")
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

  /**
   * Retrieves a list of all Posts.
   *
   * @return A list of posts.
   */
  @Operation(
      summary = "Fetches all Indeed Posts",
      description =
          "Fetches all Indeed Posts entities and their data from data source")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
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
  
  
  /**
   * Deletes all Posts.
   */
  @Operation(
      summary = "Deletes all Indeed Posts",
      description =
          "Deletes all Indeed Posts entities and their data from data source")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
  @DeleteMapping("/deleteAll")
  public ResponseEntity<?> deleteAllPosts() {
    try {
    	 indeedService.deleteAllPosts();
      return ResponseEntity.status(HttpStatus.OK).body("All Posts are Deleted");

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
