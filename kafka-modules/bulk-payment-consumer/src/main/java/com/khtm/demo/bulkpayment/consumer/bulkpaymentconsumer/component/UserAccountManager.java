package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.component;

import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.db.AccountRepository;
import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.db.BulkPaymentLogRepository;
import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.entity.BulkPayment;
import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.service.AccountService;
import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.service.CIFService;
import com.khtm.demo.bulkpayment.model.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserAccountManager {

    private static final String TAG = "UserAccountManager";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BulkPaymentLogRepository bulkPaymentLogRepository;

    private int getUserBalance(long userId){
        int balance = 0;
        for (UserAccount userAccount : accountService.getUserAccountByUserId(userId)) {
            balance += Integer.parseInt(userAccount.getBalance());
        }
        logger.info(String.format("balance user <%d> is -> %d", userId, balance));
        return balance;
    }

    private UserAccount getFirstUserAccount(long userId){
        return accountService.getUserAccountByUserId(userId).get(0);
    }

    private void increaseBalanceUser(long userReceiver, int amount){
        try {
            UserAccount userAccount = this.getFirstUserAccount(userReceiver);
            int balance = Integer.parseInt(userAccount.getBalance()) + amount;
            userAccount.setBalance(String.valueOf(balance));
            accountRepository.save(userAccount);
        }catch (Exception e){
            UserAccount userAccount = new UserAccount();
            userAccount.setBalance(String.valueOf(amount));
            userAccount.setUserId(userReceiver);
            accountRepository.save(userAccount);
        }
    }

    private void decreaseBalanceUser(long userPayer, int amount){
        UserAccount userAccount = this.getFirstUserAccount(userPayer);
        int balance = Integer.parseInt(userAccount.getBalance()) - amount;
        userAccount.setBalance(String.valueOf(balance));
        accountRepository.save(userAccount);
    }

    public boolean payUser(long userPayer, long userReceiver, int amount){
        boolean ans = false;
        int balance = getUserBalance(userPayer);
        if(balance >= amount){
            this.increaseBalanceUser(userReceiver, amount);
            this.decreaseBalanceUser(userPayer, amount);
            ans = true;
            // insert record into database
            BulkPayment bulkPayment = new BulkPayment();
            bulkPayment.setAmount(String.valueOf(amount));
            bulkPayment.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
            bulkPayment.setUserIdReceiver(userReceiver);
            bulkPayment.setUserIdPayer(userPayer);
            bulkPaymentLogRepository.save(bulkPayment);
        }
        /**
         * check all user account for negative balance;
         * */
        return ans;
    }

}
