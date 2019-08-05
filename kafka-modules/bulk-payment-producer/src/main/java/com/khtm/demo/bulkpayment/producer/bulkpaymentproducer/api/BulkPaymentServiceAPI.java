package com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.api;

import com.khtm.demo.bulkpayment.model.kafka.BulkPayment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bulk-payment")
public interface BulkPaymentServiceAPI {

    @RequestMapping(method = RequestMethod.POST, value = "/request")
    void sendBulkPaymentRequest(@RequestBody BulkPayment bulkPayment);

}
