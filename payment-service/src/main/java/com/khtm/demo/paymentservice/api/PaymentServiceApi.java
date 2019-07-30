package com.khtm.demo.paymentservice.api;

import com.khtm.demo.paymentservice.model.PaymentRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public interface PaymentServiceApi {
    @RequestMapping(method = RequestMethod.POST, value = "/all")
    List<PaymentRecord> getAllPaymention();
    @RequestMapping(method = RequestMethod.POST, value = "/payer")
    List<PaymentRecord> getPaymentByUserIdPayer(@RequestParam(name = "id") long userId);
    @RequestMapping(method = RequestMethod.POST, value = "/receiver")
    List<PaymentRecord> getPaymentByUserIdReceiver(@RequestParam(name = "id") long userId);
    @RequestMapping(method = RequestMethod.POST, value = "/add-record")
    void saveRecord(PaymentRecord paymentRecord);
}
