package com.example.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  UserID;
    private String UserFullName;
    private String JiraUsername;
    private String Username;
    private String Email;
    private String Grade;
    private String Status;
    private Date HiringDate;
    private float  RemainVacation;
    private int SocialID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "LogTime",
            joinColumns = @JoinColumn(name = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "TaskId")
    )
    private Set<Task> tasks = new HashSet<>();



    public User(Long userID, String userFullName, String jiraUsername, String username, String email, String grade, String status, Date hiringDate, float remainVacation, int socialID, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Task> tasks) {
        UserID = userID;
        UserFullName = userFullName;
        JiraUsername = jiraUsername;
        Username = username;
        Email = email;
        Grade = grade;
        Status = status;
        HiringDate = hiringDate;
        RemainVacation = remainVacation;
        SocialID = socialID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tasks = tasks;
    }

    public User() {
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void setUserID(Long  userID) {
        UserID = userID;
    }

    public void setUserFullName(String userFullName) {
        UserFullName = userFullName;
    }

    public void setJiraUsername(String jiraUsername) {
        JiraUsername = jiraUsername;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setHiringDate(Date hiringDate) {
        HiringDate = hiringDate;
    }

    public void setRemainVacation(float remainVacation) {
        RemainVacation = remainVacation;
    }

    public void setSocialID(int socialID) {
        SocialID = socialID;
    }

    public void setCreatedAt(LocalDateTime  createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime  updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long  getUserID() {
        return UserID;
    }

    public String getUserFullName() {
        return UserFullName;
    }

    public String getJiraUsername() {
        return JiraUsername;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getGrade() {
        return Grade;
    }

    public String getStatus() {
        return Status;
    }

    public Date getHiringDate() {
        return HiringDate;
    }

    public float getRemainVacation() {
        return RemainVacation;
    }

    public int getSocialID() {
        return SocialID;
    }

    public LocalDateTime  getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime  getUpdatedAt() {
        return updatedAt;
    }
}