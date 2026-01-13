package com.Project.Task_Manager.Controller;

import com.Project.Task_Manager.DTO.TaskMailRequestDTO;
import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Model.User;
import com.Project.Task_Manager.Service.EmailService;
import com.Project.Task_Manager.Service.TaskService;
import com.Project.Task_Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;
    @Autowired
    UserService userservice;
    @Autowired
    TaskService taskService;

@PostMapping("/taskassigmentmail")
 public ResponseEntity<String> sendTaskAssignmentMail(@RequestBody TaskMailRequestDTO tmr){

         User user = userservice.getUserById(tmr.getUserId());
         Task task = taskService.getTaskById(tmr.getTaskId());


     String string = emailService.sendTaskAssignmentMail(user,task);
     return new ResponseEntity<>(string, HttpStatus.OK);

 }









}
