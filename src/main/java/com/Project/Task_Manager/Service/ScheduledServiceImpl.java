package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//File upload/download API
//
//Scheduler (@Scheduled) for reminders
//
//External API integration (consume a REST API with RestTemplate or WebClient)
@Service
public class ScheduledServiceImpl implements ScheduledService{

    @Autowired
  EmailService emailService;

    @Autowired
    TaskService taskService;


    @Override
    public String sendingDailyPendingTaskRemainder()
    {
      List<Task> ltask= taskService.getAllPendingTask();
      for(Task task:ltask){ // enhanced foreloop   loop through each pending  task
          User user=task.getUserAssigned();  // get the user of each task
          emailService.sendTaskReminderMail(user,task);  // email is send to each user
      }

        return "send"+ltask.size()+"reminder";
    }
}
