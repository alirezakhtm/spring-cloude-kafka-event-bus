package com.khtm.demo.paymentservice.service;

import com.khtm.demo.paymentservice.api.PaymentServiceApi;
import com.khtm.demo.paymentservice.db.PaymentRepository;
import com.khtm.demo.paymentservice.model.PaymentRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentService implements PaymentServiceApi {

    private static final String TAG = "PaymentService";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentRecord> getAllPaymention() {
        List<PaymentRecord> lstPaymention = new ArrayList<>();
        paymentRepository.findAll().forEach(paymentRecord -> lstPaymention.add(paymentRecord));
        return lstPaymention;
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
        logger.info(String.format("ID->%d, Amount->%s, Date->%s, ID Payer->%d, ID Receiver->%d",
                paymentRecord.getId(),
                paymentRecord.getAmount(),
                paymentRecord.getDatePayment(),
                paymentRecord.getUserIdPayer(),
                paymentRecord.getUserIdReceiver()));
        paymentRepository.save(paymentRecord);
    }
}
