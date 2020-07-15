package com.my.user.config;

import com.my.common.ResData;
import com.my.utils.ResDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 处理数据处理出错异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResData handle(Exception e){
        if (e instanceof ShoppingException){
            ShoppingException ze = (ShoppingException) e;
            return ResDataUtil.failRun(ze.getCode(),ze.getMessage());
        } else {
            logger.error("[系统异常]{}", e);
            return ResDataUtil.error();
        }
    }

    /**
     * 处理MyException异常
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResData handleMyException(MyException e) {
        return ResDataUtil.failRun("500", e.getInfo());
    }
}