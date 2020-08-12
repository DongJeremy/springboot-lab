package org.springboot.lab.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.lab.jpa.model.User;
import org.springboot.lab.jpa.repository.UserRepository01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository01Test {

    @Autowired
    private UserRepository01 userRepository;

    @Test // 插入一条记录
    public void testSave() {
        User user = new User().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date());
        userRepository.save(user);
    }

    @Test // 更新一条记录
    public void testUpdate() {
        // 先查询一条记录
        Optional<User> user = userRepository.findById(1);
        Assert.isTrue(user.isPresent(), "记录不能为空");
        // 更新一条记录
        User updateUser = user.get();
        updateUser.setPassword("yudaoyuanma");
        userRepository.save(updateUser);
    }

    @Test // 根据 ID 编号，删除一条记录
    public void testDelete() {
        userRepository.deleteById(2);
    }

    @Test // 根据 ID 编号，查询一条记录
    public void testSelectById() {
        Optional<User> user = userRepository.findById(1);
        System.out.println(user.get());
    }

    @Test // 根据 ID 编号数组，查询多条记录
    public void testSelectByIds() {
        Iterable<User> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }

}
