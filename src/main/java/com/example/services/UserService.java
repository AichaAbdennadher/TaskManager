package com.example.services;

import com.example.models.Task;
import com.example.models.User;
import com.example.repositories.TaskRepository;
import com.example.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
