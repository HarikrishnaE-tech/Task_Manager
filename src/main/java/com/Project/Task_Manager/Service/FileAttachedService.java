package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.FileAttached;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileAttachedService {

    public FileAttached storeFile(MultipartFile file, Long taskid);

    public FileAttached getFile(Long fileid);

    public List<FileAttached> getFilesofTask(Long taskid);

    public String deleteFile(Long fileid);




}
