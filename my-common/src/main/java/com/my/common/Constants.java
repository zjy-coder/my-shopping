package com.my.common;

import lombok.Data;

/**
 * @Date 2020-07-14 16:35
 * @Created by zjy
 * 定义工程的返回状态
 */
public enum Constants {
    SUCCESS("000","成功"),
    Fail("001","失败"),
    ERROR("-1","未知错误"),
    ILLEGAL_PARAM("002","非法参数"),
    ;

    private String code;
    private String msg;

    Constants(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
