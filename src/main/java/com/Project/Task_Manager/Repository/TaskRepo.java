package com.Project.Task_Manager.Repository;

import com.Project.Task_Manager.Model.Status;
import com.Project.Task_Manager.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    Task getProjectByProjectId(Long projectid);

    List<Task> findByUserAssigned_Id(Long userId);

    List<Task> getStatus(Status status);

}
