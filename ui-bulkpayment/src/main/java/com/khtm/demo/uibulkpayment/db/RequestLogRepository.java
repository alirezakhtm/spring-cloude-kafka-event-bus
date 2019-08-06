package com.khtm.demo.uibulkpayment.db;

import com.khtm.demo.uibulkpayment.model.RequestBulkPayment;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RequestLogRepository extends Repository<RequestBulkPayment, Long> {
    List<RequestBulkPayment> findAll();
}
