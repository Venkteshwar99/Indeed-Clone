package com.Indeed.Service;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import java.util.List;
import java.util.Optional;

public interface IndeedService {

  public Indeed createPost(IndeedDto dto);

  public List<Indeed> getAllPosts();

  public String deletePostById(long id);

  public void deleteAllPosts();

  Optional<Indeed> getPostsById(long id) throws Exception;

  public Indeed updatePost(IndeedDto updatedPost, long id) throws Exception;
}
