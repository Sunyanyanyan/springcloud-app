package com.cn.springcloudconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
//@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@SpringCloudApplication //组合注解 相当于 @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class SpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }

}
