package com.khtm.demo.cifservice.api;

import com.khtm.demo.cifservice.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public interface CifAPI {
    @RequestMapping(method = RequestMethod.POST, path = "/all")
    List<User> getAllUser();
    @RequestMapping(method = RequestMethod.POST, path = "/id")
    User getUserInfo(@RequestParam(name = "id") long id);
    @RequestMapping(method = RequestMethod.POST, path = "/identity-number")
    User getUserInfo(@RequestParam(name = "identityNumber") String identityNumber);
}
