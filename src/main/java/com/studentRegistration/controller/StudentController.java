package com.studentRegistration.controller;

import com.studentRegistration.entity.Student;
import com.studentRegistration.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentServices studentServices;

  @PostMapping(value = "/save")
  public String saveStudent(@RequestBody Student students){

    studentServices.saveOrUpdate(students);

    return students.getId();
  }

  @GetMapping(value = "/getAll")
  public Iterable<Student> getStudents (){

    return studentServices.listAll();
  }

  @PutMapping(value = "/edit/{id}")
  public Student updateStudent(@RequestBody Student student,@PathVariable(name = "id")String id){

    student.setId(id);
    studentServices.saveOrUpdate(student);
    return student;
  }

  @DeleteMapping("/delete/{id}")
  private void deleteStudent(@PathVariable("id")String id){

    studentServices.deleteStudent(id);
  }

  @RequestMapping("/search/{id}")
  private  Student getStudents(@PathVariable(name = "id")String studentId){
    return studentServices.getStudentById(studentId);
  }


}
