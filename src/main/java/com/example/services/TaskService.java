package com.example.services;

import com.example.models.Task;
import com.example.models.User;
import com.example.repositories.TaskRepository;

import java.time.LocalDate;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}

