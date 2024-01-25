package com.Indeed.Dto;

import java.util.Arrays;

public class IndeedDto {

  private String profile;

  private String type;

  private String description;

  private String experience;

  private String technology[];

  private String salary;

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

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public IndeedDto() {}

  public IndeedDto(
      String profile,
      String type,
      String description,
      String experience,
      String[] technology,
      String salary) {
    super();
    this.profile = profile;
    this.type = type;
    this.description = description;
    this.experience = experience;
    this.technology = technology;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "IndeedDto [profile="
        + profile
        + ", type="
        + type
        + ", description="
        + description
        + ", experience="
        + experience
        + ", technology="
        + Arrays.toString(technology)
        + ", salary="
        + salary
        + "]";
  }
}
