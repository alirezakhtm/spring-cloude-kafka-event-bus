package com.khtm.demo.uibulkpayment.controller;

import com.khtm.demo.uibulkpayment.db.BulkPaymentLogRepository;
import com.khtm.demo.uibulkpayment.db.RequestLogRepository;
import com.khtm.demo.uibulkpayment.model.BulkPaymentLog;
import com.khtm.demo.uibulkpayment.model.RequestBulkPayment;
import com.khtm.demo.uibulkpayment.model.User;
import com.khtm.demo.uibulkpayment.model.UserAccount;
import com.khtm.demo.uibulkpayment.service.AccountService;
import com.khtm.demo.uibulkpayment.service.CIFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.channels.FileChannel;
import java.util.List;

@Controller
public class UIController {

    @Autowired
    private CIFService cifService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RequestLogRepository requestLogRepository;

    @Autowired
    private BulkPaymentLogRepository bulkPaymentLogRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user-info")
    public String userInfo(Model model){
        List<User> users = cifService.getAllUser();
        model.addAttribute("users", users);
        return "user-info";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/account-info")
    public String accountInfo(Model model){
        List<UserAccount> userAccounts = accountService.getAllAccountInformation();
        model.addAttribute("userAccounts", userAccounts);
        return "account-info";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/request-log")
    public String requestLog(Model model){
        List<RequestBulkPayment> requests = requestLogRepository.findAll();
        model.addAttribute("requests", requests);
        return "request-log";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bulk-payment")
    public String bulkPayment(Model model){
        List<BulkPaymentLog> logs = bulkPaymentLogRepository.findAll();
        model.addAttribute("logs", logs);
        return "bulk-payment";
    }



}
