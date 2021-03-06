package com.my.user.controller;

import com.my.common.ResData;
import com.my.user.entity.User;
import com.my.utils.ResDataUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020-07-14 16:59
 * @Created by zjy
 */
@RestController
public class UserController {
    @Value("${user.name}")
    private String value;

    @GetMapping("/test")
    public ResData test(){
        User user = new User();
        user.setName(value);
        user.setPhone("18329344212");
        return ResDataUtil.success(user);
    }
}
