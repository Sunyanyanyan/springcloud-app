package com.cn.springcloudprovider.mapper;

import com.cn.springcloudprovider.entity.User;
import org.apache.ibatis.annotations.Mapper;

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


    /**
     * 修改用户
     */
    int updateUserByUid(User user);

    /**
     * 删除用户
     */
    int deleteUserByUid(String uId);

    /**
     * 用户登录
     */
    List<User> loginUser(User user);
}
