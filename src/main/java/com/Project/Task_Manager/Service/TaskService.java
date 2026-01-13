package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Status;
import com.Project.Task_Manager.Model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public Task createTask(Task task);

    public List<Task>  getAllTAsk();

    public Task updateTask(Long taskid, Status status);

    public String reassignTask(Long userid, Long taskid);

    public Task getTaskByProject(Long projectid);

    List<Task> findTasksByUserId(Long userId);

    public Task getAssignedTo(Long userid, Long taskid);
    public List<Task> getAllPendingTask();

    public Task getTaskById(Long taskid);


}
