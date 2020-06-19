package com.taskmanagement.mongo.api.repository;
import com.taskmanagement.mongo.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
