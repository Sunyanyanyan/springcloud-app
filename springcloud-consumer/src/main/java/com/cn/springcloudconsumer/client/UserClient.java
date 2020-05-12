package com.cn.springcloudconsumer.client;

import com.cn.springcloudconsumer.client.impl.UserClientFallBack;
import com.cn.springcloudconsumer.entity.User;
import com.cn.springcloudconsumer.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-PROVIDER", fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/provider/user/queryUserByName")
    String queryUserByName(@RequestParam("uUsername") String uUsername);

    @GetMapping("/provider/user/queryUserAll")
    String queryUserAll();
}
