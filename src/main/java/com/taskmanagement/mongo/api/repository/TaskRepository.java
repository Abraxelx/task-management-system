package com.taskmanagement.mongo.api.repository;

import com.taskmanagement.mongo.api.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface TaskRepository extends MongoRepository<Task, String> {
    Task findTaskByDueTo_Date(Date dueTo);
    Task findTaskByTitle(String Title);
}
