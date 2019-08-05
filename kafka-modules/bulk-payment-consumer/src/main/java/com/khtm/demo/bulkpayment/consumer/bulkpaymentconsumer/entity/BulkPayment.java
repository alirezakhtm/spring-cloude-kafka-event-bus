package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_bulkpayment", catalog = "db_bank")
public class BulkPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "USER_ID_PAYER")
    private long userIdPayer;
    @Column(name = "USER_ID_RECEIVER")
    private long userIdReceiver;
    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
