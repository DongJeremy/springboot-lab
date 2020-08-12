package org.springboot.lab.mongo.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.lab.mongo.Application;
import org.springboot.lab.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test // 插入一条记录
    public void testInsert() {
        // 创建 UserDO 对象
        User user = new User();
        user.setId(1); // 这里先临时写死一个 ID 编号，后面演示自增 ID 的时候，在修改这块
        user.setUsername("yudaoyuanma");
        user.setPassword("buzhidao");
        user.setCreateTime(new Date());
        // 创建 Profile 对象
        User.Profile profile = new User.Profile();
        profile.setNickname("芋道源码");
        profile.setGender(1);
        user.setProfile(profile);
        // 存储到 DB
        userDao.insert(user);
    }

    // 这里要注意，如果使用 save 方法来更新的话，必须是全量字段，否则其它字段会被覆盖。
    // 所以，这里仅仅是作为一个示例。
    @Test // 更新一条记录
    public void testUpdate() {
        // 创建 UserDO 对象
        User updateUser = new User();
        updateUser.setId(1);
        updateUser.setUsername("nicai");

        // 执行更新
        userDao.updateById(updateUser);
    }

    @Test // 根据 ID 编号，删除一条记录
    public void testDelete() {
        userDao.deleteById(1);
    }

    @Test // 根据 ID 编号，查询一条记录
    public void testSelectById() {
        User userDO = userDao.findById(1);
        System.out.println(userDO);
    }

    @Test // 根据 ID 编号数组，查询多条记录
    public void testSelectByIds() {
        List<User> users = userDao.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }

}
