package com.demomybatisplus.model;

import lombok.Data;

/**
 * @program: demo-mybatis-plus
 * @description: xx
 * @author: wanghaoming
 * @create: 2022-04-27 14:26
 **/
@Data
public class LoginUser {

    private String username;
    private String password;
    private Integer rememberMe;
}
