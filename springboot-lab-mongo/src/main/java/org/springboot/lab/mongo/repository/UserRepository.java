package org.springboot.lab.mongo.repository;

import org.springboot.lab.mongo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUsername(String username);

    Page<User> findByUsernameLike(String username, Pageable pageable);
}
