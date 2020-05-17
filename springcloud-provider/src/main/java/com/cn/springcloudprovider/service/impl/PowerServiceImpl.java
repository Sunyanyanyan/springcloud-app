package com.cn.springcloudprovider.service.impl;


import com.cn.springcloudprovider.entity.Power;
import com.cn.springcloudprovider.mapper.PowerMapper;
import com.cn.springcloudprovider.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<Power> queryAll(Power power) {
        return powerMapper.queryAll(power);
    }
}
