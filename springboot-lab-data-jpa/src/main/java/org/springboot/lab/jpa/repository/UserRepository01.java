package org.springboot.lab.jpa.repository;

import org.springboot.lab.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository01 extends CrudRepository<User, Integer> {

}
