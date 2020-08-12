package org.springboot.lab.jpa.repository;

import org.springboot.lab.jpa.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository02 extends PagingAndSortingRepository<User, Integer> {

}
