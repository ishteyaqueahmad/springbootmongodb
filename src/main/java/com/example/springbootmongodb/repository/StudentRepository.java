package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
}
