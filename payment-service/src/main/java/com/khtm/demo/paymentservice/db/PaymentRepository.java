package com.khtm.demo.paymentservice.db;

import com.khtm.demo.paymentservice.model.PaymentRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface PaymentRepository extends /*Repository<PaymentRecord, Long>, */CrudRepository<PaymentRecord, Long> {
    /*List<PaymentRecord> findAll();
    List<PaymentRecord> findAllByUserIdPayer(long userId);
    List<PaymentRecord> findAllByUserIdReceiver(long userId);*/
    List<PaymentRecord> findAllByUserIdPayer(long userId);
    List<PaymentRecord> findAllByUserIdReceiver(long userId);

    @Override
    @Transactional(timeout = 8)
    Iterable<PaymentRecord> findAll();
}
