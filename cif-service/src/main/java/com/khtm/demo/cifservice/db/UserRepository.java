package com.khtm.demo.cifservice.db;

import com.khtm.demo.cifservice.model.User;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends Repository<User, Long> {

    User findByIdentityNumber(String identityNumber);
    User findById(long id);
    List<User> findAll();

}
