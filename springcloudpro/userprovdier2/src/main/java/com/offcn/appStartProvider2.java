package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class appStartProvider2 {
    public static void main(String[] args) {
        SpringApplication.run(appStartProvider2.class,args);
    }
}
