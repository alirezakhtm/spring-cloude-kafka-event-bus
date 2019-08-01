package com.khtm.demo.bulkpaymentservice.listener;

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

}
