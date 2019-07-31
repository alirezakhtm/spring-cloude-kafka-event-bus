package com.khtm.demo.paymentservice.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_payment", catalog = "db_bank")
public class PaymentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "USERID_PAYER")
    private long userIdPayer;
    @Column(name = "USERID_RECEIVER")
    private long userIdReceiver;
    @Column(name = "DATE_PAYMENT")
    private String datePayment;
    @Column(name = "AMOUNT")
    private String amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserIdPayer() {
        return userIdPayer;
    }

    public void setUserIdPayer(long userIdPayer) {
        this.userIdPayer = userIdPayer;
    }

    public long getUserIdReceiver() {
        return userIdReceiver;
    }

    public void setUserIdReceiver(long userIdReceiver) {
        this.userIdReceiver = userIdReceiver;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
