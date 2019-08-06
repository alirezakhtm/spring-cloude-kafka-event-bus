package com.khtm.demo.uibulkpayment.db;

import com.khtm.demo.uibulkpayment.model.BulkPaymentLog;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BulkPaymentLogRepository extends Repository<BulkPaymentLog, Long> {
    List<BulkPaymentLog> findAll();
}
