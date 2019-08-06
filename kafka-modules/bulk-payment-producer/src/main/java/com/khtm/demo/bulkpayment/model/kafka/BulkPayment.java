package com.khtm.demo.bulkpayment.model.kafka;

import java.util.List;

public class BulkPayment {

    private long userIdPayer;
    private List<Long> userIdReceiver;
    private String amount;

    public long getUserIdPayer() {
        return userIdPayer;
    }

    public void setUserIdPayer(long userIdPayer) {
        this.userIdPayer = userIdPayer;
    }

    public List<Long> getUserIdReceiver() {
        return userIdReceiver;
    }

    public void setUserIdReceiver(List<Long> userIdReceiver) {
        this.userIdReceiver = userIdReceiver;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
