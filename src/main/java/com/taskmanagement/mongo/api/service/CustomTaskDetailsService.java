package com.taskmanagement.mongo.api.service;

import com.taskmanagement.mongo.api.model.Task;
import com.taskmanagement.mongo.api.model.User;
import com.taskmanagement.mongo.api.repository.TaskRepository;
import com.taskmanagement.mongo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Service
public class CustomTaskDetailsService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetailsService userService;

    public Task findTaskByDueTo(Date dueTo){
        return taskRepository.findTaskByDueTo_Date(dueTo);
    }
    public Task findTaskByTitle(String title){
        return taskRepository.findTaskByTitle(title);
    }

    public void saveTask(Task task){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(authentication.getName());
            task.setText(task.getText());
            task.setTitle(task.getTitle());
            task.setDueTo(task.getDueTo());
            task.setUserSet(new HashSet<>(Arrays.asList(user)));
            taskRepository.save(task);
    }
}
