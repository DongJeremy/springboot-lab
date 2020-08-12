package org.springboot.lab.jpa;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.lab.jpa.model.User;
import org.springboot.lab.jpa.repository.UserRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository04Test {

    @Autowired
    private UserRepository04 userRepository;

    @Test
    public void testFindIdByUsername01() {
        User user = userRepository.findByUsername01("yunai");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername02() {
        User user = userRepository.findByUsername02("yunai");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername03() {
        User user = userRepository.findByUsername03("yunai");
        System.out.println(user);
    }

    @Test
    // 更新操作，需要在事务中。
    // 在单元测试中，事务默认回滚，所以胖友可能怎么测试，事务都不更新。
    @Transactional
    public void testUpdateUsernameById() {
        userRepository.updateUsernameById(5, "yudaoyuanma");
    }

}
