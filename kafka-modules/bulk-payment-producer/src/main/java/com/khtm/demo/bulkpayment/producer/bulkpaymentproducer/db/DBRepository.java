package com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.db;

import com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.entity.RequestBulkPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DBRepository extends CrudRepository<RequestBulkPayment, Long> {
}
