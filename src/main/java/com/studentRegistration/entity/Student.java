package com.studentRegistration.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Getter
@Setter
public class Student {

  @Id
  private String id;
  private String studentName;
  private String studentAddress;
  private String mobile;
}
