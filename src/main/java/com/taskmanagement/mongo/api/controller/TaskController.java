package com.taskmanagement.mongo.api.controller;

import com.taskmanagement.mongo.api.model.Task;
import com.taskmanagement.mongo.api.repository.TaskRepository;
import com.taskmanagement.mongo.api.service.CustomTaskDetailsService;
import com.taskmanagement.mongo.api.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/taskboard")
public class TaskController {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private CustomTaskDetailsService customTaskDetailsService;

    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping
    public ModelAndView findAllTasks(Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks",tasks);
        return new ModelAndView("taskboard", "tasks", tasks);
    }


    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public String createNewTask(Task task) {
        ModelAndView modelAndView = new ModelAndView();
        customTaskDetailsService.saveTask(task);
        modelAndView.addObject("successMessage", "Task has been created successfully");
        modelAndView.addObject("task", new Task());
        modelAndView.setViewName("taskboard");
        return "redirect:/taskboard";
    }
}
