package com.example.controllers;


import com.example.models.LogTime;
import com.example.models.Task;
import com.example.models.User;
import com.example.repositories.LogTimeRepository;
import com.example.repositories.TaskRepository;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private LogTimeRepository logTimeRepository;
    @PostMapping("/{userId}/tasks/{taskId}")
    public void addTaskToUser(@PathVariable Long userId, @PathVariable Long taskId) {
        // Find the user and task by their IDs
        User user = userRepository.findById(userId).orElse(null);
        Task task = taskRepository.findById(taskId).orElse(null);

        // If both user and task exist, add the task to the user's tasks set
        if (user != null && task != null) {
            user.getTasks().add(task);
            userRepository.save(user);
            task.getUsers().add(user);
            taskRepository.save(task);
            LogTime logTime = new LogTime();
            logTime.setUser(user);
            logTime.setTask(task);
            logTime.setCreatedAt(LocalDateTime.now());
            logTime.setUpdatedAt(LocalDateTime.now()); // Optional, depending on your requirements
            logTimeRepository.save(logTime);
        } else {
            // Handle the case when the user or task is not found
            // You can throw an exception, return an error response, etc.
            // For simplicity, we're not handling the error here
        }
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping
    public User addUser(@RequestBody User User) {

        return userRepository.save(User);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        existingUser.setUserFullName(updatedUser.getUserFullName());
        existingUser.setJiraUsername(updatedUser.getJiraUsername());
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setGrade(updatedUser.getGrade());
        existingUser.setStatus(updatedUser.getStatus());
        existingUser.setHiringDate(updatedUser.getHiringDate());
        existingUser.setRemainVacation(updatedUser.getRemainVacation());
        existingUser.setSocialID(updatedUser.getSocialID());
        existingUser.setCreatedAt(updatedUser.getCreatedAt());
        existingUser.setUpdatedAt(updatedUser.getUpdatedAt());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
