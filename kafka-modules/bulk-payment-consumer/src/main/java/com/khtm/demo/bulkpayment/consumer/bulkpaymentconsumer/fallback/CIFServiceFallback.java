package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.fallback;

import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.service.CIFService;
import com.khtm.demo.bulkpayment.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CIFServiceFallback implements CIFService {
    @Override
    public List<User> getAllUser() {
        return new ArrayList<>();
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
        user.setIdentityNumber("0000000000");
        return user;
    }
}
