package com.cn.springcloudconsumer.controller;

import com.cn.springcloudconsumer.entity.User;
import com.cn.springcloudconsumer.vo.Result;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class UserController {
    public static final String PROVIDER_URL = "http://SERVICE-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user/queryUserAll")
    public Result<User> queryUserAll(User user) {
        return restTemplate.postForObject(PROVIDER_URL + "/provider/user/queryUserAll", user, Result.class);
    }

    @GetMapping("/consumer/user/addUser")
    public Result<User> addUser(User user) {
        log.info("==================/consumer/user/addUser================");
        return restTemplate.postForObject(PROVIDER_URL + "/provider/user/addUser", user, Result.class);
    }
}
