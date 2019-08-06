package com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_request_bulkpayment", catalog = "db_bank")
public class RequestBulkPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "REQUEST")
    private String request;
    @Column(name = "REQUEST_DATE")
    private String paymentDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
