package com.cn.springcloudprovider.controller;


import com.cn.springcloudprovider.entity.User;
import com.cn.springcloudprovider.service.UserService;
import com.cn.springcloudprovider.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("用户接口")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/provider/user/queryUserByName",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("查询用户信息")
    @ApiImplicitParam(name = "uUsername", value = "用户名称", required = true, type = "String")
    public Result<User> queryUserByName(User user) {
        return userService.queryUserByName(user);
    }


    @GetMapping(value = "/provider/user/queryUserAll",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("查询所有用户信息")
    public Result<User> queryUserAll(){
        return userService.queryUserAll();
    }

    @PostMapping(value = "/provider/user/addUser", produces = {"application/json;charset=UTF-8"})
    @ApiModelProperty(value = "添加用户", notes = "以实体类为参数")
    public Result<User> addUser(@ApiParam(name = "user", value = "用户") @RequestBody User user) {
        return userService.addUser(user);
    }

}