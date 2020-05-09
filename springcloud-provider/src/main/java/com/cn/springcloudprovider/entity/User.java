package com.cn.springcloudprovider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "用户")
public class User implements Serializable {

    private static final long serialVersionUID = 7873715063175730718L;

    @ApiModelProperty(name = "uId", value = "主键", dataType = "String")
    private String uId;

    @ApiModelProperty(name = "uUsername", value = "用户名", dataType = "String")
    private String uUsername;

    @ApiModelProperty(name = "uPassword", value = "密码", dataType = "String")
    private String uPassword;

    @ApiModelProperty(name = "uName", value = "姓名", dataType = "String")
    private String uName;

    @ApiModelProperty(name = "uPhone", value = "联系电话", dataType = "String")
    private String uPhone;

    @ApiModelProperty(name = "uEmail", value = "邮箱", dataType = "String")
    private String uEmail;

    @ApiModelProperty(name = "uNormal", value = "账户是否正常", dataType = "String")
    private String uNormal;
}
