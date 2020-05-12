package com.cn.springcloudprovider.mapper;

import com.cn.springcloudprovider.entity.User;
import com.cn.springcloudprovider.vo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户名查询用户
     */
    List<User> queryUserByName(User user);

    /**
     * 根据条件查询结果条数
     */
    int queryCountUser(User user);

    /**
     * 查询所有用户
     */
    List<User> queryUserAll();
}
