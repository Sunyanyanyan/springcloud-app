package com.cn.springcloudprovider.controller;


import com.cn.springcloudprovider.entity.User;
import com.cn.springcloudprovider.service.UserService;
import com.cn.springcloudprovider.vo.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("用户接口")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/provider/user/queryUserByName",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("根据用户名查询用户信息")
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

    @PutMapping(value = "/provider/user/updateUserByUid",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uId", value = "主键", required = true, type = "String"),
            @ApiImplicitParam(name = "uUsername", value = "用户名称", required = false, type = "String"),
            @ApiImplicitParam(name = "uPassword", value = "密码", required = false, type = "String"),
            @ApiImplicitParam(name = "uName", value = "姓名", required = false, type = "String"),
            @ApiImplicitParam(name = "uPhone", value = "联系电话", required = false, type = "String"),
            @ApiImplicitParam(name = "uEmail", value = "邮箱", required = false, type = "String"),
            @ApiImplicitParam(name = "uNormal", value = "账户是否正常", required = false, type = "String")
    })
    public Result<User> updateUserByUid(User user){
        return userService.updateUserByUid(user);
    }

    @DeleteMapping(value = "/provider/user/deleteUserByUid", produces = {"application/json;charset=UTF-8"})
    @ApiOperation("删除用户")
    public Result<User> deleteUserByUid(@ApiParam(name = "uId", value = "主键") @RequestBody String uId) {
        return userService.deleteUserByUid(uId);
    }

    @PostMapping(value = "/provider/user/loginUser" ,produces = {"application/json;charset=UTF-8"})
    @ApiOperation("用户登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "uUsername",value = "用户名称", required = true, type = "String"),
        @ApiImplicitParam(name = "uPassword",value = "密码", required = true, type = "String")
    })
    public Result<User> loginUser(User user) {
        return userService.loginUser(user);
    }

}