package com.cn.springcloudconsumer.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Power implements Serializable {

    private static final long serialVersionUID = 3583036682151815429L;

    /**
     * 主键
     */
    private String pId;
    /**
     * 资源名称
     */
    private String pName;
    /**
     * 资源路径
     */
    private String pUrl;
    /**
     * 资源类型
     */
    private String pType;
}
