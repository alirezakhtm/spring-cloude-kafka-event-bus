package com.khtm.demo.accountservice.db;

import com.khtm.demo.accountservice.model.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    List<UserAccount> getAll();
    List<UserAccount> getUserAccountsByUserId(long userId);
}
