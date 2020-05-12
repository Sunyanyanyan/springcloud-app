package com.cn.springcloudprovider.service;

import com.cn.springcloudprovider.entity.User;
import com.cn.springcloudprovider.vo.Result;

public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    Result<User> addUser(User user);

    Result<User> queryUserAll();

    Result<User> queryUserByName(User user);
}
