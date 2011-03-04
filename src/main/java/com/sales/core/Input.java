/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.core;

import com.genrep.persistence.service.AEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kiril
 */
public class Input extends AEntity {
    // enter date for the invoice

    private Date date = new Date();
    // internal number for the invoce
    private String number;
    // invoice number
    private String invoiceNumber;
    // complete value for the invoice
    private BigDecimal price;
    // company
    private Organization organization;
    /// view fields
    List<Input> tableList;
    Integer current;
    Integer tableListSize;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTableListSize() {
        if (tableList != null) {
            tableListSize = tableList.size();
        }
        return tableListSize;
    }

    public void setTableListSize(Integer tableListSize) {
        if (tableList != null) {
            tableListSize = tableList.size();
        }
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public List<Input> getTableList() {
        return tableList;
    }

    public void setTableList(List<Input> tableList) {
        this.tableList = tableList;
    }
}
