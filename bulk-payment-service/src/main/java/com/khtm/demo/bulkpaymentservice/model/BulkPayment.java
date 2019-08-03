package com.khtm.demo.bulkpaymentservice.model;

import java.util.List;

public class BulkPayment {

    private long idUserPayer;
    private List<Long> idReceiverUsers;
    private String amount;

    public long getIdUserPayer() {
        return idUserPayer;
    }

    public void setIdUserPayer(long idUserPayer) {
        this.idUserPayer = idUserPayer;
    }

    public List<Long> getIdReceiverUsers() {
        return idReceiverUsers;
    }

    public void setIdReceiverUsers(List<Long> idReceiverUsers) {
        this.idReceiverUsers = idReceiverUsers;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
