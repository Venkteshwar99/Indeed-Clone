package com.Indeed.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Indeed {

  @NotNull @NotEmpty private String profile;

  @NotNull private String type;

  @NotNull private String description;

  @NotNull private String experience;

  @NotNull private String technology[];

  @CreatedDate private Date createdAt;

  @NotNull private String salary;

  public String getProfile() {
	return profile;
}

public void setProfile(String profile) {
	this.profile = profile;
}



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public String getExperience() {
	return experience;
}



public void setExperience(String experience) {
	this.experience = experience;
}



public String[] getTechnology() {
	return technology;
}



public void setTechnology(String[] technology) {
	this.technology = technology;
}



public Date getCreatedAt() {
	return createdAt;
}



public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}



public String getSalary() {
	return salary;
}



public void setSalary(String salary) {
	this.salary = salary;
}


public Indeed(@NotNull @NotEmpty String profile, @NotNull String type, @NotNull String description,
		@NotNull String experience, @NotNull String[] technology, Date createdAt, @NotNull String salary) {
	super();
	this.profile = profile;
	this.type = type;
	this.description = description;
	this.experience = experience;
	this.technology = technology;
	this.createdAt = createdAt;
	this.salary = salary;
}

public Indeed() {
    // TODO Auto-generated constructor stub
  }

@Override
public String toString() {
	return "Indeed [profile=" + profile + ", type=" + type + ", description=" + description + ", experience="
			+ experience + ", technology=" + Arrays.toString(technology) + ", createdAt=" + createdAt + ", salary="
			+ salary + "]";
}


}
