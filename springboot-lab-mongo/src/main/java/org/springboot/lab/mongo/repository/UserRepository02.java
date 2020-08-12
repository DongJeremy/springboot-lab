package org.springboot.lab.mongo.repository;

import org.springboot.lab.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository02 extends MongoRepository<User, Integer> {
}
