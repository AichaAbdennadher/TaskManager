package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class LogTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    @Column(name = "log_time_id")
    private Long logTimeId;


    @ManyToOne
    @JoinColumn(name = "UserId")
    private User User;
    @ManyToOne
    @JoinColumn(name = "TaskId")
    private Task Task;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LogTime(Long logTimeId, com.example.models.User user, com.example.models.Task task, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.logTimeId = logTimeId;
        User = user;
        Task = task;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LogTime() {

    }


    public Long getLogTimeId() {
        return logTimeId;
    }

    public void setLogTimeId(Long logTimeId) {
        this.logTimeId = logTimeId;
    }

    public com.example.models.User getUser() {
        return User;
    }

    public void setUser(com.example.models.User user) {
        User = user;
    }

    public com.example.models.Task getTask() {
        return Task;
    }

    public void setTask(com.example.models.Task task) {
        Task = task;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}