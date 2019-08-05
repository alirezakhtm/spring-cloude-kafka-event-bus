package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.listener;

import com.khtm.demo.bulkpayment.model.kafka.BulkPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private static final String TAG = "KafkaConsumerListener";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @KafkaListener(topics = "bulk_payment", groupId = "group-json")
    public void DoBulkPayment(BulkPayment bulkPayment){
        /**
         * Process must be inserted here.
         * */
        logger.info("Received new bulk-payment request from kafka queue.");
    }

}
