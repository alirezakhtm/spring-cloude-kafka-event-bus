package com.khtm.demo.accountservice.api;

import com.khtm.demo.accountservice.model.UserAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public interface UserAccountServiceApi {
    @RequestMapping(method = RequestMethod.POST, value = "/all")
    List<UserAccount> getAllAccountInformation();
    @RequestMapping(method = RequestMethod.POST, value = "/user-id")
    List<UserAccount> getUserAccountByUserId(@RequestParam(name = "id") long userId);
    @RequestMapping(method = RequestMethod.POST, value = "/id")
    UserAccount getUserAccountById(@RequestParam(name = "id") long id);
}
