package com.cn.springcloudprovider.mapper;

import com.cn.springcloudprovider.entity.User;
import com.cn.springcloudprovider.vo.Result;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    Result<User> queryUserAll();
}
