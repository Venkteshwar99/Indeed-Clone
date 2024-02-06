package com.Indeed.Controller;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Service.IndeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Tag(name = "Indeed Controller", description = "Indeed Posts API's")
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
      description = "Fetches all Indeed Posts entities and their data from data source")
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
   * Retrieves an posts by ID.
   *
   * @param id The ID of the post to retrieve.
   * @return The retrieved post.
   */
  @Operation(
      summary = "Retrieve a Post by ID",
      description = "Get a Post object by specifying its ID.")
  @GetMapping(path = "/getPost/{id}")
  public ResponseEntity<Object> getPostById(@PathVariable("id") long id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(indeedService.getPostsById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  /**
   * Updates an existing post.
   *
   * @param id The ID of the post to be updated.
   * @return The updated post.
   */
  @Operation(
      summary = "Update a Post by ID",
      description = "Update a Post object by specifying its ID.")
  @PutMapping(
      path = "/update/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<?> upatePost(
      @RequestBody IndeedDto updatedPost, @PathVariable("id") long id) {
    try {

      Indeed updatePost = indeedService.updatePost(updatedPost, id);

      return ResponseEntity.status(HttpStatus.OK).body("Updated Post: " + updatePost);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  /** Deletes all Posts. */
  @Operation(
      summary = "Deletes all Indeed Posts",
      description = "Deletes all Indeed Posts entities and their data from data source")
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

  /**
   * Deletes an Post by their ID.
   *
   * @param id The ID of the Post to be deleted.
   * @return A no content response.
   */
  @Operation(
      summary = "Delete a Post by ID",
      description = "Delete a Post object by specifying its ID.")
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<String> deletePostById(@PathVariable("id") long id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(indeedService.deletePostById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }
}
