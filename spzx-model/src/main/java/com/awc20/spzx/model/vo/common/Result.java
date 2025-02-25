package com.awc20.spzx.model.vo.common;

import lombok.Data;

@Data
public class Result<T> {

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    // 私有化构造
    private Result() {}

    // 返回数据
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<>();
        result.setData(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    //成功的结果集
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setMessage("成功");
        return result;
    }
    //失败的结果集
    public static <T> Result<T> fail(String errorMessage) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setData(null);
        result.setMessage(errorMessage);
        return result;
    }
}