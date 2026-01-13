package com.Project.Task_Manager.Repository;

import com.Project.Task_Manager.Model.FileAttached;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FileAttachedrepo extends JpaRepository<FileAttached,Long> {

    List<FileAttached> getFilesofTask(Long Taskid);

}
