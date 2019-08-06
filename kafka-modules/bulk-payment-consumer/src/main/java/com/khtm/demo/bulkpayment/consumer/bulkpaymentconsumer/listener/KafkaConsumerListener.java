package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.listener;

import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.component.UserAccountManager;
import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.service.AccountService;
import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.service.CIFService;
import com.khtm.demo.bulkpayment.model.UserAccount;
import com.khtm.demo.bulkpayment.model.kafka.BulkPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumerListener {

    private static final String TAG = "KafkaConsumerListener";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Autowired
    private UserAccountManager userAccountManager;

    @KafkaListener(topics = "bulk_payment_request", groupId = "group-json", containerFactory = "bulkPaymentKafkaConsumer")
    public void DoBulkPayment(BulkPayment bulkPayment){
        logger.info("Received new bulk-payment request from kafka queue.");
        logger.info(bulkPayment.toString());
        bulkPayment.getUserIdReceiver().forEach(userReceiver -> {
            long userPayer = bulkPayment.getUserIdPayer();
            int amount = Integer.parseInt(bulkPayment.getAmount());
            userAccountManager.payUser(userPayer, userReceiver, amount);
        });

    }



}
