package com.pinming.wk.Schedule;


import com.pinming.wk.mapper.t0Mapper;
import com.pinming.wk.model.t0;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Schedule {

    @Resource
    private t0Mapper t0Mapper;

    @Scheduled(cron = "*/10 * * * * ?")
    public void test() {
        int i = 0;
        while (i < 200) {
            t0Mapper.insert(new t0());
            i++;
        }
    }

}
