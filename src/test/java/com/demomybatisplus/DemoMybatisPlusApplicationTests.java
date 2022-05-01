//package com.demomybatisplus;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.demomybatisplus.dao.User;
//import com.demomybatisplus.mapper.UserMapper;
//import com.demomybatisplus.service.UserService;
//import org.hamcrest.core.IsNot;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//class DemoMybatisPlusApplicationTests {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testSelectList() {
//
//        List<User> users = userMapper.selectList(null);
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testInsert() {
//        User user = new User();
//        user.setName("张三");
//        user.setAge(18);
//        user.setEmail("zhangsan@atguigu.com");
//        int result = userMapper.insert(user);
//        System.out.println("result" + result);
//        System.out.println("id" + user.getId());
//    }
//
//    @Test
//    public void selectMapById() {
//        Map<String, Object> map = userMapper.selectMapById(1L);
//        System.out.println(map);
//    }
//
//    @Test
//    public void testGetCount() {
//        // 查询总记录数的
//        // SELECT COUNT( * ) FROM user
//        long count = userService.count();
//        System.out.println(count);
//    }
//
//    @Test
//    public void testInsertMore() {
//        List<User> list = new ArrayList<>();
//        for (int i = 0; i <= 10; i++) {
//            User user = new User();
//            user.setName("ch" + i);
//            user.setAge(20 + i);
//            list.add(user);
//        }
//        boolean b = userService.saveBatch(list);
//        System.out.println(b);
//    }
//
//    @Test
//    public void testSelectWrapper() {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "a")
//                .between("age", 20, 30)
//                .isNotNull("email");
//        List<User> userList = userMapper.selectList(queryWrapper);
//        userList.forEach(System.out::println);
//    }
//
//    @Test
//    public void test02() {
//        // 查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
//        // SELECT id,name,age,email FROM user ORDER BY age DESC,id ASC
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("age")
//                .orderByAsc("id");
//        List<User> list = userMapper.selectList(queryWrapper);
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    public void test03() {
//        // 删除邮箱地址null的用户信息
//        // DELETE FROM user WHERE (email IS NULL)
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.isNull("email");
//        int i = userMapper.delete(queryWrapper);
//        System.out.println(i);
//    }
//
//    @Test
//    public void test04() {
//        // 将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
//        // UPDATE user SET name=?, email=? WHERE (age > ? AND name LIKE ? OR email IS NULL)
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.gt("age", 20)
//                .like("name", "a")
//                .or()
//                .isNull("email");
//        User user = new User();
//        user.setName("小明");
//        user.setEmail("test@atguigu.com");
//        int update = userMapper.update(user, queryWrapper);
//        System.out.println(update);
//    }
//
//    @Test
//    public void test05() {
//        // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
//        // Lambda中的条件优先执行
//        // UPDATE user SET name=?, email=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "a")
//                .and(i -> i.gt("age", 20)
//                        .or()
//                        .isNull("email"));
//        User user = new User();
//        user.setName("小红");
//        user.setEmail("tset@atguigu.com");
//        int result = userMapper.update(user, queryWrapper);
//        System.out.println(result);
//
//    }
//
//    @Test
//    public void test06() {
//        // 查询用户的用户名，年龄，邮箱信息
//        // SELECT name,age,email FROM user
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("name", "age", "email");
//        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
//        maps.forEach(System.out::println);
//
//    }
//
//    @Test
//    public void test07() {
//        // 查询id小于等于100的用户信息
//        // SELECT id,name,age,email FROM user WHERE (id IN (select id from user where id <= 100))
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.inSql("id", "select id from user where id <= 100");
//        List<User> list = userMapper.selectList(queryWrapper);
//        list.forEach(System.out::println);
//
//    }
//
//    @Test
//    public void test08() {
//        // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
//        // UPDATE user SET name=?,email=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
//        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.like("name", "a")
//                .and(i -> i.gt("age", 20)
//                        .or()
//                        .isNull("email"));
//        updateWrapper.set("name", "小黑");
//        updateWrapper.set("email", "abc@atguigu.com");
//        int update = userMapper.update(null, updateWrapper);
//        System.out.println(update);
//
//    }
//
//    @Test
//    public void test09() {
//        String username = "";
//        Integer ageBegin = 20;
//        Integer ageEnd = 30;
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        if (StringUtils.isEmpty(username)) {
//            // 判断某个字符串是否不为空字符串，不为null，不为空白符
//            // SELECT id,name,age,email FROM user WHERE (age >= ? AND age <= ?)
//            queryWrapper.like("name", username);
//        }
//        if (ageBegin != null) {
//            queryWrapper.ge("age", ageBegin);
//        }
//        if (ageEnd != null) {
//            queryWrapper.le("age", ageEnd);
//
//        }
//        List<User> list = userMapper.selectList(queryWrapper);
//        list.forEach(System.out::println);
//    }
//}