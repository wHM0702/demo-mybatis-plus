//package com.demomybatisplus.mapper;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.demomybatisplus.dao.User;
//import org.apache.ibatis.annotations.MapKey;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
///**
// * @program: demo-mybatis-plus
// * @description: xx
// * @author: wanghaoming
// * @create: 2022-04-22 15:32
// **/
//@Repository
//public interface UserMapper extends BaseMapper<User> {
//
//    /**
//     * 根据id查询用户信息为map集合
//     * @param id
//     * @return
//     */
//
//    @MapKey("id")
//    Map<String, Object> selectMapById(@Param("id") Long id);
//
//}
