package org.springboot.lab.mongo.repository;

import org.springboot.lab.mongo.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository03 extends MongoRepository<User, Integer> {

    // 使用 username 精准匹配
    default User findByUsername01(String username) {
        // 创建 Example 对象，使用 username 查询
        User probe = new User();
        probe.setUsername(username); // 精准匹配 username 查询
        Example<User> example = Example.of(probe);
        // 执行查询
        return findOne(example)
                .orElse(null); // 如果为空，则返回 null
    }

    // 使用 username 模糊匹配
    default User findByUsernameLike01(String username) {
        // 创建 Example 对象，使用 username 查询
        User probe = new User();
        probe.setUsername(username); // 这里还需要设置
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains()); // 模糊匹配 username 查询
        Example<User> example = Example.of(probe, matcher);
        // 执行查询
        return findOne(example)
                .orElse(null); // 如果为空，则返回 null
    }

}
