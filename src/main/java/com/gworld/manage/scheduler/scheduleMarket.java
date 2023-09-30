package com.gworld.manage.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Component
public class scheduleMarket {

    //    @Scheduled(cron = "0 15 1 15 * ?")
    @Scheduled(cron = "* */59 * * * *")
//    @Scheduled(cron = "* * * * * *")
    public void scheduleMarket() throws InterruptedException{
        long now = System.currentTimeMillis() / 1000;
        System.out.println("schedule:"+now);
        log.info("schedule2:"+now);

    }
    public void crolling(){

    }
}
