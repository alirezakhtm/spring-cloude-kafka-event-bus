package com.khtm.demo.uibulkpayment.fallback;

import com.khtm.demo.uibulkpayment.model.User;
import com.khtm.demo.uibulkpayment.service.CIFService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CIFServiceFallback implements CIFService {
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        users.add(getNullUser());
        return users;
    }

    @Override
    public User getUserInfo(long id) {
        return this.getNullUser();
    }

    @Override
    public User getUserInfo(String identityNumber) {
        return this.getNullUser();
    }

    private User getNullUser(){
        User user = new User();
        user.setId(0);
        user.setFirstname("unknown");
        user.setLastname("unknown");
        user.setIdentityNumber("0");
        return user;
    }
}
