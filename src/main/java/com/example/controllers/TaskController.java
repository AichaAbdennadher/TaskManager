package com.example.controllers;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.example.models.Task;
import com.example.repositories.TaskRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600) //bch mt3mlch mchkl fi front
@RestController
@RequestMapping("/api/Tasks") //kn fi controller
public class TaskController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

   @GetMapping("/getTasksByDueDate/{dueDate}")
    public List<Task> getTasksByDueDate( @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dueDate) {
        return taskRepository.findTasksByDueDate(dueDate);
    }


    @GetMapping("getTasksByUserAndDueDate")
    public List<Task> getTasksByUserAndDueDate(@RequestParam Long userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dueDate) {

        // Assuming you have a service method to fetch the user by ID
        User user = userRepository.findById(userId).orElse(null);

        return taskRepository.findTasksByUserAndDueDate(user, dueDate);
    }

  @GetMapping("/getTasksByUserAndPeriod")
    public List<Task> getTasksByUserAndPeriod(@RequestParam Long userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

        User user = userRepository.findById(userId).orElse(null);

        return taskRepository.findTasksByUserAndPeriod(user, startDate,endDate);
    }
  @GetMapping("/getTasksByPeriod")
  public List<Task> getTasksByPeriod(
          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
      return taskRepository.findTasksByPeriod(startDate, endDate);
  }

    @GetMapping("/getTasksByUser/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        return taskRepository.findTasksByUser(user);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @PostMapping
    public Task addTask(@RequestBody Task Task) {
        return taskRepository.save(Task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        existingTask.setSource(updatedTask.getSource());
        existingTask.setTaskType(updatedTask.getTaskType());
        existingTask.setTaskLevel(updatedTask.getTaskLevel());
        existingTask.setPercentage(updatedTask.getPercentage());
        existingTask.setSummary(updatedTask.getSummary());
        existingTask.setAdjustedTargetHTCs(updatedTask.getAdjustedTargetHTCs());
        existingTask.setAdjustedTargetHLReqs(updatedTask.getAdjustedTargetHLReqs());
        existingTask.setAdjustedAmountOfTickets(updatedTask.getAdjustedAmountOfTickets());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCustomLabel(updatedTask.getCustomLabel());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setIdSprint(updatedTask.getIdSprint());
        existingTask.setIdParentTask(updatedTask.getIdParentTask());
        existingTask.setIdResource(updatedTask.getIdResource());
        existingTask.setIdProject(updatedTask.getIdProject());
        existingTask.setCreatedBy(updatedTask.getCreatedBy());
        existingTask.setUpdatedBy(updatedTask.getUpdatedBy());
        existingTask.setCalculatedTargetHLTCs(updatedTask.getCalculatedTargetHLTCs());
        existingTask.setStoryPoint(updatedTask.getStoryPoint());
        existingTask.setIdDepartement(updatedTask.getIdDepartement());
        existingTask.setE_Complex(updatedTask.getE_Complex());
        existingTask.setE_Meduim(updatedTask.getE_Meduim());
        existingTask.setE_Simple(updatedTask.getE_Simple());
        existingTask.setCreatedAt(LocalDateTime.now()); // You can choose whether to update the createdAt field
        existingTask.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(existingTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
