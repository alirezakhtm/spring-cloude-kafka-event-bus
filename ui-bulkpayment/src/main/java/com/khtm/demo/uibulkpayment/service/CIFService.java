package com.khtm.demo.uibulkpayment.service;

import com.khtm.demo.uibulkpayment.fallback.CIFServiceFallback;
import com.khtm.demo.uibulkpayment.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "CIF-SERVICE", fallback = CIFServiceFallback.class)
public interface CIFService {

    @RequestMapping(value = "/user/all", method = RequestMethod.POST)
    List<User> getAllUser();
    @RequestMapping(method = RequestMethod.POST, path = "/user/id")
    User getUserInfo(@RequestParam(name = "id") long id);
    @RequestMapping(method = RequestMethod.POST, path = "/user/identity-number")
    User getUserInfo(@RequestParam(name = "identityNumber") String identityNumber);

}
