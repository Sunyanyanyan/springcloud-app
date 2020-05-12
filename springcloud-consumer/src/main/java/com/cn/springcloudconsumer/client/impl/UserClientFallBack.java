package com.cn.springcloudconsumer.client.impl;

import com.cn.springcloudconsumer.client.UserClient;
import com.cn.springcloudconsumer.entity.User;
import com.cn.springcloudconsumer.vo.CodeMsg;
import com.cn.springcloudconsumer.vo.Result;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserClient {


    @Override
    public String queryUserAll() {
        String ret = "***********queryUserAll出错了***********";
        return ret;
    }

    @Override
    public String queryUserByName(String uUsername) {
        Result result = new Result(0,HttpStatus.SC_INTERNAL_SERVER_ERROR,"服务器正忙",null);
        return result.toString();
    }


}
