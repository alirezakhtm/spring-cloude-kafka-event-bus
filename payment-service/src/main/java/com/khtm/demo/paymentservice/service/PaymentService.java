package com.khtm.demo.paymentservice.service;

import com.khtm.demo.paymentservice.api.PaymentServiceApi;
import com.khtm.demo.paymentservice.db.PaymentRepository;
import com.khtm.demo.paymentservice.model.PaymentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentService implements PaymentServiceApi {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentRecord> getAllPaymention() {
        return paymentRepository.findAll();
    }

    @Override
    public List<PaymentRecord> getPaymentByUserIdPayer(long userId) {
        return paymentRepository.findAllByUserIdPayer(userId);
    }

    @Override
    public List<PaymentRecord> getPaymentByUserIdReceiver(long userId) {
        return paymentRepository.findAllByUserIdReceiver(userId);
    }

    @Override
    public void saveRecord(PaymentRecord paymentRecord) {
        paymentRepository.save(paymentRecord);
    }
}
