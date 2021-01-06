package com.zyfgoup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Zyfgoup
 * @Date 2020/12/18 14:31
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
