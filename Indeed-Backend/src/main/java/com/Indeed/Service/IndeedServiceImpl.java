package com.Indeed.Service;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Repository.IndeedRepo;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndeedServiceImpl implements IndeedService {

  @Autowired IndeedRepo indeedRepo;

  @Override
  public Indeed createPost(IndeedDto dto) {

    Indeed indeed = new Indeed();
    indeed.setId(generateUniqueId());
    indeed.setProfile(dto.getProfile());
    indeed.setDescription(dto.getDescription());
    indeed.setExperience(dto.getExperience());
    indeed.setSalary(dto.getSalary());
    indeed.setType(dto.getType());
    indeed.setTechnology(dto.getTechnology());
    indeed.setCreatedAt(new Date());
    return indeedRepo.save(indeed);
  }

  @Override
  public List<Indeed> getAllPosts() {
    List<Indeed> results = indeedRepo.findAll();
    if (results.isEmpty()) {
      throw new RuntimeException("No Records Found In DB");
    } else {
      return results;
    }
  }

  @Override
  public Optional<Indeed> getPostsById(long id) throws Exception {
    Optional<Indeed> getPost = indeedRepo.findById(id);
    if (getPost.isPresent()) {
      return getPost;
    } else {
      throw new Exception("Post Not found with Id:" + id);
    }
  }

  public Indeed updatePost(IndeedDto updatedPost, long id) throws Exception {
    Optional<Indeed> employee = getPostsById(id);
    if (employee.isPresent()) {
      Indeed indeed = new Indeed();
      indeed.setId(employee.get().getId());
      indeed.setProfile(updatedPost.getProfile());
      indeed.setDescription(updatedPost.getDescription());
      indeed.setExperience(updatedPost.getExperience());
      indeed.setSalary(updatedPost.getSalary());
      indeed.setType(updatedPost.getType());
      indeed.setTechnology(updatedPost.getTechnology());
      indeed.setCreatedAt(employee.get().getCreatedAt());
      return indeedRepo.save(indeed);
    } else {
      throw new RuntimeException("Id not present in Db: " + id);
    }
  }

  @Override
  public String deletePostById(long id) {
    if (indeedRepo.existsById(id)) {
      indeedRepo.deleteById(id);
      return "Post Deleted With Id: " + id;
    } else {
      throw new RuntimeException("Post Not found with Id:" + id);
    }
  }

  @Override
  public void deleteAllPosts() {
    indeedRepo.deleteAll();
  }

  private long generateUniqueId() {
    Optional<Indeed> maxID = indeedRepo.findFirstByOrderByIdDesc();
    long id = maxID.map(Indeed::getId).orElse(0L) + 1;
    return id;
  }
}
