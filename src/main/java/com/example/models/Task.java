package com.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  TaskID;
    private String Source;
    private String TaskType;
    private int TaskLevel;
    private int  Percentage;
    private String Summary;
    private int  AdjustedTargetHTCs;
    private int  AdjustedTargetHLReqs;
    private int  AdjustedAmountOfTickets;
    private String Description;
    private String CustomLabel;
    private String Priority;
    private Date DueDate;
    private int IdSprint;
    private int IdParentTask;
    private int IdResource;
    private int IdProject;
    private int  CreatedBy;
    private int UpdatedBy;
    private int CalculatedTargetHLTCs;
    private float StoryPoint;
    private int IdDepartement;
    private int E_Complex;
    private int E_Meduim;
    private int E_Simple;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnore
    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();


    public Task(Long taskID, String source, String taskType, int taskLevel, int percentage, String summary, int adjustedTargetHTCs, int adjustedTargetHLReqs, int adjustedAmountOfTickets, String description, String customLabel, String priority, Date dueDate, int idSprint, int idParentTask, int idResource, int idProject, int createdBy, int updatedBy, int calculatedTargetHLTCs, float storyPoint, int idDepartement, int e_Complex, int e_Meduim, int e_Simple, LocalDateTime createdAt, LocalDateTime updatedAt, Set<User> users) {
        TaskID = taskID;
        Source = source;
        TaskType = taskType;
        TaskLevel = taskLevel;
        Percentage = percentage;
        Summary = summary;
        AdjustedTargetHTCs = adjustedTargetHTCs;
        AdjustedTargetHLReqs = adjustedTargetHLReqs;
        AdjustedAmountOfTickets = adjustedAmountOfTickets;
        Description = description;
        CustomLabel = customLabel;
        Priority = priority;
        DueDate = dueDate;
        IdSprint = idSprint;
        IdParentTask = idParentTask;
        IdResource = idResource;
        IdProject = idProject;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CalculatedTargetHLTCs = calculatedTargetHLTCs;
        StoryPoint = storyPoint;
        IdDepartement = idDepartement;
        E_Complex = e_Complex;
        E_Meduim = e_Meduim;
        E_Simple = e_Simple;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.users = users;
    }

    public Task() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setTaskID(Long  taskID) {
        TaskID = taskID;
    }

    public void setSource(String source) {
        Source = source;
    }

    public void setTaskType(String taskType) {
        TaskType = taskType;
    }

    public void setTaskLevel(int taskLevel) {
        TaskLevel = taskLevel;
    }

    public void setPercentage(int percentage) {
        Percentage = percentage;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public void setAdjustedTargetHTCs(int adjustedTargetHTCs) {
        AdjustedTargetHTCs = adjustedTargetHTCs;
    }

    public void setAdjustedTargetHLReqs(int adjustedTargetHLReqs) {
        AdjustedTargetHLReqs = adjustedTargetHLReqs;
    }

    public void setAdjustedAmountOfTickets(int adjustedAmountOfTickets) {
        AdjustedAmountOfTickets = adjustedAmountOfTickets;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCustomLabel(String customLabel) {
        CustomLabel = customLabel;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }

    public void setIdSprint(int idSprint) {
        IdSprint = idSprint;
    }

    public void setIdParentTask(int idParentTask) {
        IdParentTask = idParentTask;
    }

    public void setIdResource(int idResource) {
        IdResource = idResource;
    }

    public void setIdProject(int idProject) {
        IdProject = idProject;
    }

    public void setCreatedBy(int createdBy) {
        CreatedBy = createdBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public void setCalculatedTargetHLTCs(int calculatedTargetHLTCs) {
        CalculatedTargetHLTCs = calculatedTargetHLTCs;
    }

    public void setStoryPoint(float storyPoint) {
        StoryPoint = storyPoint;
    }

    public void setIdDepartement(int idDepartement) {
        IdDepartement = idDepartement;
    }

    public void setE_Complex(int e_Complex) {
        E_Complex = e_Complex;
    }

    public void setE_Meduim(int e_Meduim) {
        E_Meduim = e_Meduim;
    }

    public void setE_Simple(int e_Simple) {
        E_Simple = e_Simple;
    }

    public void setCreatedAt(LocalDateTime  createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime  updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long  getTaskID() {
        return TaskID;
    }

    public String getSource() {
        return Source;
    }

    public String getTaskType() {
        return TaskType;
    }

    public int getTaskLevel() {
        return TaskLevel;
    }

    public int getPercentage() {
        return Percentage;
    }

    public String getSummary() {
        return Summary;
    }

    public int getAdjustedTargetHTCs() {
        return AdjustedTargetHTCs;
    }

    public int getAdjustedTargetHLReqs() {
        return AdjustedTargetHLReqs;
    }

    public int getAdjustedAmountOfTickets() {
        return AdjustedAmountOfTickets;
    }

    public String getDescription() {
        return Description;
    }

    public String getCustomLabel() {
        return CustomLabel;
    }

    public String getPriority() {
        return Priority;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public int getIdSprint() {
        return IdSprint;
    }

    public int getIdParentTask() {
        return IdParentTask;
    }

    public int getIdResource() {
        return IdResource;
    }

    public int getIdProject() {
        return IdProject;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public int getCalculatedTargetHLTCs() {
        return CalculatedTargetHLTCs;
    }

    public float getStoryPoint() {
        return StoryPoint;
    }

    public int getIdDepartement() {
        return IdDepartement;
    }

    public int getE_Complex() {
        return E_Complex;
    }

    public int getE_Meduim() {
        return E_Meduim;
    }

    public int getE_Simple() {
        return E_Simple;
    }

    public LocalDateTime  getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime  getUpdatedAt() {
        return updatedAt;
    }
}
