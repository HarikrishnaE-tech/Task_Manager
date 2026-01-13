package com.Project.Task_Manager.DTO;

import java.util.List;

public class TaskMailRequestDTO {

    private Long userId;
    private Long taskId;

    // Default constructor (IMPORTANT for JSON binding)
    public TaskMailRequestDTO() {
    }

    // Parameterized constructor (optional)
    public TaskMailRequestDTO(Long userId, Long taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }

    // Getters & Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}




















