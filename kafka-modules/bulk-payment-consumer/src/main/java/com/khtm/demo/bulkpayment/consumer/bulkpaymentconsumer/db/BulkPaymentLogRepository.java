package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.db;

import com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.entity.BulkPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BulkPaymentLogRepository extends CrudRepository<BulkPayment, Long> {
}
