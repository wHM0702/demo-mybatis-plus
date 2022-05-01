package com.demomybatisplus.service.impl;

import com.demomybatisplus.dao.UserRepository;
import com.demomybatisplus.entity.Users;
import com.demomybatisplus.utils.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: demo-mybatis-plus
 * @description: xx
 * @author: wanghaoming
 * @create: 2022-04-27 11:27
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users byUsername = userRepository.findByUsername(username);
        return new JwtUser(byUsername);
    }
}
