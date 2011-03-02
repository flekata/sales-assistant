/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.core;

import com.genrep.document.ADocument;

/**
 *
 * @author Kiril Arsov
 */
public class Organization extends ADocument {

    private String name;
    private String accountNumber;
    private String contact;
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
