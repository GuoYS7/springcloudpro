package com.offcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard   //启动熔断
public class AppStartHystrix {
    public static void main(String[] args) {
        SpringApplication.run(AppStartHystrix.class,args);
    }
}
