package com.Indeed.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

@Schema(description = "Indeed Model Information")
public class IndeedDto {

  @Schema(description = "Id", example = "1")
  private long id;

  @Schema(description = "Profile", example = "Java Developer")
  private String profile;

  @Schema(description = "Type", example = "Online/Offline")
  private String type;

  @Schema(description = "Description", example = "Java(multi-skilled) developer required")
  private String description;

  @Schema(description = "Experience", example = "0-2 Years")
  private String experience;

  @Schema(description = "Technology", example = "Java, React")
  private String technology[];

  @Schema(description = "Salary", example = "Rs 0-300000")
  private String salary;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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
      long id,
      String profile,
      String type,
      String description,
      String experience,
      String[] technology,
      String salary) {
    super();
    this.id = id;
    this.profile = profile;
    this.type = type;
    this.description = description;
    this.experience = experience;
    this.technology = technology;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "IndeedDto [id="
        + id
        + ", profile="
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
