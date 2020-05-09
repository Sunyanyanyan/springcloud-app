package com.cn.springcloudprovider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@ApiModel(value = "返回结构")
public class NumberData<T> {

    @ApiModelProperty(name = "total", value = "总条数", dataType = "int")
    private int total;

    @ApiModelProperty(name = "datalist", value = "数据", dataType = "Object")
    private List<T> datalist;
}
