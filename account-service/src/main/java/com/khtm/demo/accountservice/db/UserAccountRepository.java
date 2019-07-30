package com.khtm.demo.accountservice.db;

import com.khtm.demo.accountservice.model.UserAccount;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserAccountRepository extends Repository<UserAccount, Long> {
    List<UserAccount> findAll();
    List<UserAccount> findAllByUserId(long userId);
    UserAccount findById(long id);
}
