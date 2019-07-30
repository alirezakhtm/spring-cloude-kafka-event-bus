package com.khtm.demo.accountservice.service;

import com.khtm.demo.accountservice.api.UserAccountServiceApi;
import com.khtm.demo.accountservice.db.UserAccountRepository;
import com.khtm.demo.accountservice.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAccountService implements UserAccountServiceApi {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public List<UserAccount> getAllAccountInformation() {
        return userAccountRepository.findAll();
    }

    @Override
    public List<UserAccount> getUserAccountByUserId(long userId) {
        return userAccountRepository.findAllByUserId(userId);
    }

    @Override
    public UserAccount getUserAccountById(long id) {
        return userAccountRepository.findById(id);
    }
}
