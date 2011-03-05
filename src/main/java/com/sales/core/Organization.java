/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.core;

import com.genrep.persistence.service.AEntity;

/**
 *
 * @author Kiril Arsov
 */
public class Organization extends AEntity {
    // bank/organization/company name
    private String name;
    // unique account number
    private String accountNumber;
    // contact number
    private String contact;
    // bank for the company
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
