package com.demomybatisplus.dao;

import com.demomybatisplus.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: demo-mybatis-plus
 * @description: xx
 * @author: wanghaoming
 * @create: 2022-04-27 11:26
 **/
@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {

    Users findByUsername(String username);
}
