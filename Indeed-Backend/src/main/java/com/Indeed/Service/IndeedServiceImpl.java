package com.Indeed.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Indeed.Dto.IndeedDto;
import com.Indeed.Model.Indeed;
import com.Indeed.Repository.IndeedRepo;

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
		List<Indeed> results = indeedRepo.findAll();
		if (results.isEmpty()) {
			throw new RuntimeException("No Records Found In DB");
		} else {
			return results;
		}
	}

	@Override
	public void deleteAllPosts() {
		indeedRepo.deleteAll();
	}
}
