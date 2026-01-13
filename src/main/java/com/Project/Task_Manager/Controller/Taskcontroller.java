package com.Project.Task_Manager.Controller;

import com.Project.Task_Manager.Model.Status;
import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Model.User;
import com.Project.Task_Manager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskapi/task")
public class Taskcontroller {

    @Autowired
    TaskService taskservice;

    @PostMapping("/createtask")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
       Task task1= taskservice.createTask(task);
       return  new ResponseEntity<>(task1, HttpStatus.OK);
    }
    @PostMapping("/getalltask")
    public ResponseEntity<List <Task>> getAllTAsk() {
        List<Task> ltask = taskservice.getAllTAsk();
        return new ResponseEntity<>(ltask, HttpStatus.OK);
    }
    @PatchMapping("/update/{taskid}/status")
    public ResponseEntity<Task> updateTask(
           @PathVariable Long taskid,
          @RequestBody Status status){
       Task task= taskservice.updateTask(taskid,status);
       return new ResponseEntity<>(task,HttpStatus.OK);
    }
    @PostMapping("/reassigntask/{userid}/{taskid}")
    public ResponseEntity<String> reassignTask(
            @PathVariable Long userid,
            @PathVariable Long taskid){
       String string= taskservice.reassignTask(userid,taskid);
       return new ResponseEntity<>(string,HttpStatus.OK);
    }
    @GetMapping("/gettaskbyproject/[projectid]")
    public ResponseEntity<Task> getTaskByProject(@PathVariable  Long projectid) {
        Task task = taskservice.getTaskByProject(projectid) ;
            return new ResponseEntity<>(task, HttpStatus.OK);

        }



        @GetMapping("/user/{userId}")
        public ResponseEntity<List<Task>> getTasksOfUser(
                @PathVariable Long userId) {

            List<Task> tasks = taskservice.findTasksByUserId(userId);
            return new ResponseEntity<>(tasks,HttpStatus.OK);
        }



        @PatchMapping("/assign/task/{taskId}/user/{userId}")
        public ResponseEntity<Task> assignTaskToUser(
                @PathVariable("taskId") Long taskId,
                @PathVariable("userId") Long userId) {

            return ResponseEntity.ok(
                    taskservice.getAssignedTo(taskId, userId)
            );
        }
    @GetMapping("/getalltask")
    public List<Task> getAllPendingTask(){
        List<Task> ltask=taskservice.getAllPendingTask();
        return ltask;
    }











}
