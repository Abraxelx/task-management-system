package com.taskmanagement.mongo.api.repository;

import com.taskmanagement.mongo.api.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository  extends MongoRepository<Role, String> {
    Role findByRole(String role);
}

