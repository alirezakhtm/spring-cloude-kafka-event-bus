package com.khtm.demo.uibulkpayment.fallback;

import com.khtm.demo.uibulkpayment.model.UserAccount;
import com.khtm.demo.uibulkpayment.service.AccountService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountServiceFallback implements AccountService {
    @Override
    public List<UserAccount> getAllAccountInformation() {
        return new ArrayList<>();
    }

    @Override
    public List<UserAccount> getUserAccountByUserId(long userId) {
        return new ArrayList<>();
    }

    @Override
    public UserAccount getUserAccountById(long id) {
        return this.getNullUserAccount();
    }

    private UserAccount getNullUserAccount(){
        UserAccount userAccount = new UserAccount();
        userAccount.setId(0);
        userAccount.setUserId(0);
        userAccount.setBalance("0.0");
        return userAccount;
    }
}
