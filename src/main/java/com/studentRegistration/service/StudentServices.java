package com.studentRegistration.service;

import com.studentRegistration.entity.Student;
import com.studentRegistration.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServices {

  @Autowired
  private StudentRepo repo;

  public void saveOrUpdate(Student students) {

    repo.save(students);
  }

  public Iterable<Student> listAll() {

      return this.repo.findAll();

  }


  public void deleteStudent(String id) {

    repo.deleteById(id);
  }

  public Student getStudentById(String studentId) {
    return  repo.findById(studentId).get();
  }
}
