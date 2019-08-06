package com.khtm.demo.uibulkpayment.service;

import com.khtm.demo.uibulkpayment.fallback.AccountServiceFallback;
import com.khtm.demo.uibulkpayment.model.UserAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ACCOUNT-SERVICE", fallback = AccountServiceFallback.class)
public interface AccountService {
    @RequestMapping(method = RequestMethod.POST, value = "/account/all")
    List<UserAccount> getAllAccountInformation();
    @RequestMapping(method = RequestMethod.POST, value = "/account/user-id")
    List<UserAccount> getUserAccountByUserId(@RequestParam(name = "id") long userId);
    @RequestMapping(method = RequestMethod.POST, value = "/account/id")
    UserAccount getUserAccountById(@RequestParam(name = "id") long id);
}
