package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Model.User;
import org.springframework.stereotype.Service;


public interface EmailService {

public String sendTaskAssignmentMail(User user, Task task);

public String sendTaskReminderMail(User user, Task task);


}
