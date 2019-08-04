package com.khtm.demo.bulkpaymentservice.model;

public class User2 {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("[first name: %s, last name: %s]", this.firstName, this.lastName);
    }
}
