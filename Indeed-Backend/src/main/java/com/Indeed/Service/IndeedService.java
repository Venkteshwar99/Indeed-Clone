package com.Indeed.Service;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import java.util.List;

public interface IndeedService {

  public Indeed createPost(IndeedDto dto);

  public List<Indeed> getAllPosts();

  public void deleteAllPosts();
}
