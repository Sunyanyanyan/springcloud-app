package com.cn.springcloudprovider.service.impl;

import com.cn.springcloudprovider.entity.User;
import com.cn.springcloudprovider.mapper.UserMapper;
import com.cn.springcloudprovider.service.UserService;
import com.cn.springcloudprovider.vo.CodeMsg;
import com.cn.springcloudprovider.vo.NumberData;
import com.cn.springcloudprovider.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
//@Transactional
public class UserServiceImpl implements UserService {

    private Result result;

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Result<User> addUser(User user) {
        log.info("-----------addUser开始了");
        try {
            int count = userMapper.addUser(user);
            result = new Result("post", new NumberData(count, null));
            log.info("-----------count = " + count);
        } catch (Exception e) {
            result = new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR, "请求失败"));
        }
        return result;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public Result queryUserAll(){
        try {
            List<User> list = userMapper.queryUserAll();
            int count = userMapper.queryCountUser(null);
            result=new Result("get",new NumberData(count,list));
        } catch (Exception e) {
            result=new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR,"请求失败"));
        }
        return result;
    }

    @Override
    public Result queryUserByName(User user) {
        if(StringUtils.isBlank(user.getUUsername())){
            result=new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR,"参数为空"));
            return result;
        }
        try {
            List<User> list = userMapper.queryUserByName(user);
            int count = userMapper.queryCountUser(user);

            result=new Result("get",new NumberData(count,list));
        } catch (Exception e) {
            result=new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR,"请求失败"));
        }
        return result;
    }

    @Override
    public Result<User> updateUserByUid(User user) {
        log.info("-----------updateUserByUid-------");
        int count = 0;
        try {
            count = userMapper.updateUserByUid(user);
            result = new Result("put", new NumberData(count, null));
        } catch (Exception e) {
            result = new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR, "请求失败"));
        }
        return result;
    }

    @Override
    public Result<User> deleteUserByUid(String uId) {
        log.info("-----------  deleteUserByUid-------");
        int count = 0;
        try {
            count = userMapper.deleteUserByUid(uId);
            result = new Result("delete", new NumberData(count, null));
        } catch (Exception e) {
            result = new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR, "请求失败"));
        }
        return result;
    }

    @Override
    public Result<User> loginUser(User user) {
        int count  = 0;
        try {
            List<User> list = userMapper.loginUser(user);
            count = userMapper.queryCountUser(user);

            if (!"正常".equals(list.get(0).getUNormal())) {
                result = new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR, "您的账号已被锁定， 请联系管理员"));
                return result;
            }
            result = new Result("post", new NumberData(count, list));
        } catch (Exception e) {
            result = new Result(new CodeMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR, "请求失败， 账号或密码错误"));
        }
        return result;
    }


}
