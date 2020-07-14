package com.my.utils;

import com.my.common.Constants;
import com.my.common.ResData;

/**
 * @Date 2020-07-14 16:34
 * @Created by zjy
 * 本类可以完成数据返回
 */
public class ResDataUtil {
    /**
     * 成功
     */
    public static ResData success(Object obj){
        ResData resData =new ResData();
        resData.setCode(Constants.SUCCESS.getCode());
        resData.setMsg(Constants.SUCCESS.getMsg());
        resData.setData(obj);
        return resData;
    }
    /**
     * 失败
     */
    public static ResData fail(){
        ResData resData =new ResData();
        resData.setCode(Constants.Fail.getCode());
        resData.setMsg(Constants.Fail.getMsg());
        return resData;
    }
}
