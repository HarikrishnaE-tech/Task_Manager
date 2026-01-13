package com.Project.Task_Manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class DailySchedular {
@Autowired
    ScheduledService scheduledService;
@Scheduled(cron = "0 0 9 * * *")  //scheduled at morning 9
public void runDailySchedularReminder(){
     String result=    scheduledService.sendingDailyPendingTaskRemainder();
   System.out.println("the daily reminder executed"+result);
}


}
