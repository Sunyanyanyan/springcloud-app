package com.cn.springcloudconsumer.controller;

import com.cn.springcloudconsumer.client.UserClient;
import com.cn.springcloudconsumer.entity.User;
import com.cn.springcloudconsumer.vo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback="methodFallBack")
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/consumer/user/queryUserAll")
    public String queryUserAll() {
        log.info("==================queryUserAll================");
        return userClient.queryUserAll().toString();
    }

    @GetMapping("/consumer/user/queryUserByName")
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "queryUserByNameFallback")
    @HystrixCommand
    public String queryUserByName(@RequestParam("uUsername") String uUsername) {
        System.out.println(uUsername + "---" + uUsername.equals("QQ"));

        if (uUsername.equals("QQ")) {    //判断熔断方法是否成功
            throw new RuntimeException();
        }
        return userClient.queryUserByName(uUsername);
    }

    //    public String queryUserByNameFallback(String username) {
//        return "服务器正忙";
//    }
//
//    //全局熔断 方法
//    public String methodFallBack() {
//        return "服务器正忙，请稍后再试";
//    }
//
    public static final String PROVIDER_URL = "http://SERVICE-PROVIDER";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user/addUser")
    public Result<User> addUser(User user) {
        log.info("==================/consumer/user/addUser================");
        return restTemplate.postForObject(PROVIDER_URL + "/provider/user/addUser", user, Result.class);
    }
}
