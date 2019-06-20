package com.my.demo1.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.my.demo1.common.enums.ResultEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse<T> {

    private int code;
    private String msg;
    //返回json时忽略null的属性
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    //失败或成功，不返回数据时
    public ResultResponse(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    //失败后不带数据只带信息
    public static ResultResponse fail(String msg){
        return new ResultResponse(ResultEnums.FAIL.getCode(),msg);
    }
    //失败后带数据和信息
    public static <T>ResultResponse fail(String msg,T t){
        return new ResultResponse<>(ResultEnums.FAIL.getCode(),msg,t);
    }
    //失败后只携带数据，不带信息
    public static <T>ResultResponse fail(T t){
        return new ResultResponse<>(ResultEnums.FAIL.getCode(),ResultEnums.FAIL.getMsg(),t);
    }
    //成功后携带数据
    public static <T>ResultResponse success(T t){
        return new ResultResponse<>(ResultEnums.SUCCESS.getCode(),ResultEnums.SUCCESS.getMsg(),t);
    }
    //成功后不带数据
    public static <T>ResultResponse success(){
        return new ResultResponse(ResultEnums.SUCCESS.getCode(),ResultEnums.SUCCESS.getMsg());
    }
}
