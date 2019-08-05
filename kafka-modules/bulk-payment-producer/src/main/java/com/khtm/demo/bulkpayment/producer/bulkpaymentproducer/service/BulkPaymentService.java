package com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.service;

import com.google.gson.GsonBuilder;
import com.khtm.demo.bulkpayment.model.kafka.BulkPayment;
import com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.api.BulkPaymentServiceAPI;
import com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.db.DBRepository;
import com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.entity.RequestBulkPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BulkPaymentService implements BulkPaymentServiceAPI {

    @Autowired
    private KafkaTemplate<String, BulkPayment> kafkaTemplate;

    @Autowired
    private DBRepository dbRepository;

    @Override
    public void sendBulkPaymentRequest(BulkPayment bulkPayment) {
        kafkaTemplate.send("bulk_payment", bulkPayment);
        String jsonRequest = new GsonBuilder().create().toJson(bulkPayment, BulkPayment.class);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        RequestBulkPayment requestBulkPayment = new RequestBulkPayment();
        requestBulkPayment.setRequest(jsonRequest);
        requestBulkPayment.setPaymentDate(dateFormat.format(date));
        dbRepository.save(requestBulkPayment);
    }
}
