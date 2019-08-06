package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.service;

import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.fallback.CIFServiceFallback;
import com.khtm.demo.bulkpayment.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "CIF-SERVICE", fallback = CIFServiceFallback.class)
public interface CIFService {

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    List<User> getAllUser();
    @RequestMapping(method = RequestMethod.POST, path = "/id")
    User getUserInfo(@RequestParam(name = "id") long id);
    @RequestMapping(method = RequestMethod.POST, path = "/identity-number")
    User getUserInfo(@RequestParam(name = "identityNumber") String identityNumber);

}
