package org.springboot.lab.rabbitmq;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.lab.mybatis.Application;
import org.springboot.lab.mybatis.mapper.UserMapper;
import org.springboot.lab.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User().setUsername(UUID.randomUUID().toString()).setPassword("nicai").setCreateTime(new Date());
        userMapper.insert(user);
        log.info("user id: {}.", user.getId());
    }

    @Test
    public void testUpdateById() {
        User updateUser = new User().setId(1).setPassword("wobucai");
        userMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(2);
        log.info("delete success.");
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        log.info("users: {}.", user);
    }

    @Test
    public void testSelectByUsername() {
        User user = userMapper.selectByUsername("yunai");
        log.info("users: {}.", user);
    }

    @Test
    public void testSelectByIds() {
        List<User> users = userMapper.selectByIds(Arrays.asList(1, 3));
        log.info("users: {}.", users.size());
    }

}
