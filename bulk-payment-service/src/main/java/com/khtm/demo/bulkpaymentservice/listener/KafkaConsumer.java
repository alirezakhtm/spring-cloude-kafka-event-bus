package com.khtm.demo.bulkpaymentservice.listener;

import com.khtm.demo.bulkpaymentservice.model.BulkPayment;
import com.khtm.demo.bulkpaymentservice.model.User2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final String TAG = "KafkaConsumer";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @KafkaListener(topics = "kafka_example", groupId = "group_id")
    public void consume(String message){
        logger.info("Consume Message is > " + message);
    }

    @KafkaListener(topics = "kafka_example_json_5", groupId = "group_json",
            containerFactory = "userConcurrentKafkaListenerContainerFactory")
    public void consumeJson(User2 user){
        logger.info("Consume JSON Message is > " + user);
    }

    @KafkaListener(topics = "core_banking_bulk_payment", groupId = "group_json",
            containerFactory = "bulkPaymentConcurrentKafkaListenerContainerFactory")
    public void consumeBulkPayment(BulkPayment bulkPayment){
        logger.info("bulk-payment received.");
    }
}
