package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.db;

import com.khtm.demo.bulkpayment.model.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<UserAccount, Long> {
}
