package com.Project.Task_Manager.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;
@Enumerated(EnumType.STRING)
    private Status status;

    private Date dueDate;

    @ManyToOne
   private  User userAssigned;

    @ManyToOne
    private Project project;

    @OneToMany
    FileAttached fileAttached;





    public Task(long id, String title, String description, Status status, Date dueDate, User userAssigned, Project project, FileAttached fileAttached) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.userAssigned = userAssigned;
        this.project = project;
        this.fileAttached = fileAttached;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(User userAssigned) {
        this.userAssigned = userAssigned;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public FileAttached getFileAttached() {
        return fileAttached;
    }

    public void setFileAttached(FileAttached fileAttached) {
        this.fileAttached = fileAttached;
    }
}
