package com.cn.springcloudprovider.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CodeMsg {

    private int retCode;
    private String message;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (CodeMsg)super.clone();
    }
}
