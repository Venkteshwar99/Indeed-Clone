package com.Indeed.Service;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Repository.IndeedRepo;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndeedServiceImpl implements IndeedService {

  @Autowired IndeedRepo indeedRepo;

  @Override
  public Indeed createPost(IndeedDto dto) {

    Indeed indeed = new Indeed();
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
    return indeedRepo.findAll();
  }
}
