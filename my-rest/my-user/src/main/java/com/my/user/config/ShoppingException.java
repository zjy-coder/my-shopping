package com.my.user.config;

import com.my.common.Constants;

/**
 * @Date 2020-07-15 11:07
 * @Created by zjy
 */
public class ShoppingException  extends RuntimeException{
    //返回code
    private String code;

    public ShoppingException(Constants re){
        super(re.getMsg());
        this.code = re.getCode();
    }

    public ShoppingException(String code, String msg){
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
