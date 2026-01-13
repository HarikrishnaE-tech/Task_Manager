package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Status;
import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Model.User;
import com.Project.Task_Manager.Repository.TaskRepo;
import com.Project.Task_Manager.Repository.projectRepo;
import com.Project.Task_Manager.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskImpl implements TaskService{

    @Autowired
    TaskRepo taskrepo;

    @Autowired
    userRepo userrepo;
    @Autowired
    projectRepo projectrepo;


    @Override
    public Task createTask(Task task) {
      List<Task> task1= taskrepo.findAll();
      Boolean t=task1.stream().anyMatch(tk->tk.getTitle().equalsIgnoreCase(task.getTitle()));
      if(!t){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,"task is already created ");
      }

        return taskrepo.save(task);
    }

    @Override
    public List<Task>  getAllTAsk() {
       return taskrepo.findAll().stream().collect(Collectors.toList());

    }

    @Override
    public Task updateTask(Long taskid, Status status) {
        Task task=taskrepo.findById(taskid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"no Task is available"));
        task.setStatus(status);
        return taskrepo.save(task);
    }

    @Override
    public String reassignTask(Long userid, Long taskid) {
       Optional<User> user1= userrepo.findById(userid);
        if(user1.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no user exist");
        }
       User user= user1.get();
       Optional<Task> task= taskrepo.findById(taskid);
       if(task.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no task available");

       }
       Task task1=task.get();

        user.setTask(task1);
        return "Task is reassigned to the User";
    }

    @Override
    public Task getTaskByProject(Long projectid) {
        return  taskrepo.getProjectByProjectId(projectid);
    }

    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return taskrepo.findByUserAssigned_Id(userId);
    }


    @Override
    public Task getAssignedTo(Long userid, Long taskid) {
    Task task= taskrepo.findById(taskid) .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Task not found"));
    User user=userrepo.findById(userid).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Task not found"));
    task.setUserAssigned(user);
    return taskrepo.save(task);
    }

    @Override
    public List<Task> getAllPendingTask() {
      return taskrepo.getStatus(Status.PENDING);

    }

    @Override
    public Task getTaskById(Long taskid) {
      Task task=  taskrepo.findById(taskid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not exist"));
      return  task;
    }


}
