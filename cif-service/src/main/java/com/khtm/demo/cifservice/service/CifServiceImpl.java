package com.khtm.demo.cifservice.service;

import com.khtm.demo.cifservice.api.CifAPI;
import com.khtm.demo.cifservice.db.UserRepository;
import com.khtm.demo.cifservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CifServiceImpl implements CifAPI {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserInfo(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserInfo(String identityNumber) {
        return userRepository.findByIdentityNumber(identityNumber);
    }
}
