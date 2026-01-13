package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{


    @Autowired
    JavaMailSender mailsender;



    @Override
    public String sendTaskAssignmentMail(User user, Task task) {
      String to= user.getEmail();
      String subject="New Task Title"+task.getTitle();

        String message = "Hello " + user.getUsername() + ",\n\n" +
                "A new task has been assigned to you.\n\n" +
                "Task: " + task.getTitle() + "\n" +
                "Description: " + task.getDescription() + "\n" +
                "Project: " + task.getProject().getName() + "\n" +
                "Status: " + task.getStatus() + "\n\n" +
                "Kindly start working on it.\n\n" +
                "Regards,\nTask Manager System";
        sendmail(to,subject,message);
        return "mail is send successfully";
    }

    @Override
    public String sendTaskReminderMail(User user, Task task) {
        String to=user.getEmail();
        String subject="Reminder-Pending task"+task.getTitle();
        String message= "Hello " + user.getUsername() + ",\n\n" +
                "This is a reminder for your pending task:\n\n" +
                "Task: " + task.getTitle() + "\n" +
                "Description: " + task.getDescription() + "\n" +
                "Project: " + task.getProject().getName() + "\n" +
                "Status: " + task.getStatus() + "\n\n" +
                "Please complete it soon.\n\n" +
                "Regards,\nTask Manager System";
        sendmail(to,subject,message);

        return "Task reminder send succesfully";
    }

    public void  sendmail(String to,String subject,String message ){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setTo("harikrishnae7510@gmail.com");

        mailsender.send(mailMessage);
    }







}
