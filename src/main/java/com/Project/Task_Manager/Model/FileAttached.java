package com.Project.Task_Manager.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FileAttached {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;
    private String fileName;

    private String ContentType;

    private Long size;

    private LocalDateTime uploadAt;

    @ManyToOne
    Task task;


    public FileAttached() {
    }

    public FileAttached(Long fid, String fileName, String contentType, Long size, LocalDateTime uploadAt, Task task) {
        this.fid = fid;
        this.fileName = fileName;
        ContentType = contentType;
        this.size = size;
        this.uploadAt = uploadAt;
        this.task = task;
    }


    public Long getFid() {
        return fid;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return ContentType;
    }

    public Long getSize() {
        return size;
    }

    public LocalDateTime getUploadAt() {
        return uploadAt;
    }

    public Task getTask() {
        return task;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setUploadAt(LocalDateTime uploadAt) {
        this.uploadAt = uploadAt;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
