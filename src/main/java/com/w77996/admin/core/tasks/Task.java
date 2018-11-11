package com.w77996.admin.core.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;



/**
 * 开启定时任务的注解
 */
@EnableScheduling
@Component
@Slf4j
public class Task {

    @Scheduled(fixedRate = 5000)
    public void job1(){
        log.info("定时任务1" + new Date());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void job2(){
        log.info("定时任务2" + new Date());
    }

}


