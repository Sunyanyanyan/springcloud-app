package com.cn.springcloudconsumer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "返回说明")
public class Result<T> {

    @ApiModelProperty(name = "result",value="成功标识(0-失败/1-成功)", dataType = "int")
    public int result;
    @ApiModelProperty(name = "returnCode",value="状态码", dataType = "int")
    public int returnCode;
    @ApiModelProperty(name = "msg",value="数据请求信息", dataType = "String")
    public String msg;
    @ApiModelProperty(name = "data",value="数据请求结果", dataType = "Object")
    public NumberData<T> data;

    public Result(CodeMsg codeMsg){
        if (StringUtils.isEmpty(codeMsg)) {
            return;
        }
        this.result=0;
        this.returnCode = codeMsg.getRetCode();
        this.msg = codeMsg.getMessage();
    }

    public Result(String method,NumberData data){
        this.result=1;
        String str="";
        switch (method){
            case "get":str="数据查询";break;
            case "post":str="数据添加";break;
            case "put":str="数据修改";break;
            case "delete":str="数据删除";break;
        }
        if(data.getTotal()!=0){
            this.returnCode=200;
            this.msg="请求成功,"+str+"成功";
            this.data=data;
        }else{
            this.returnCode=200;
            this.msg="请求成功,但"+str+"失败";
        }
    }

}
