package com.my.common;

import lombok.Data;

/**
 * @Date 2020-07-14 16:33
 * @Created by zjy
 * 返回的基本数据封装
 */
@Data
public class ResData {
    private String code;
    private String msg;
    private Object data;
}
