package com.studentRegistration.repository;

import com.studentRegistration.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository <Student,String>{

}
