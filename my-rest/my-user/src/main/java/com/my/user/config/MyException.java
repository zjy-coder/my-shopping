package com.my.user.config;

import lombok.Data;

/**
 * @Date 2020-07-15 11:05
 * @Created by zjy
 */
@Data
public class MyException extends Exception {
    private String info;

    public MyException(String info) {
        this.setInfo(info);
    }
}
