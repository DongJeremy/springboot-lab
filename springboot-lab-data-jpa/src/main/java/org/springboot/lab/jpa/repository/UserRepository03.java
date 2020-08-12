package org.springboot.lab.jpa.repository;

import java.util.Date;

import org.springboot.lab.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository03 extends PagingAndSortingRepository<User, Integer> {

    User findByUsername(String username);

    Page<User> findByCreateTimeAfter(Date createTime, Pageable pageable);

}
