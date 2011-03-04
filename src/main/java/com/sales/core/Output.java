/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.core;

import com.genrep.persistence.service.AEntity;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author kiril
 */
public class Output extends AEntity {

    // invoice (Input)
    private Input inp;
    // flag if the invoice is fully paid
    private Boolean paid;
    // flag if the invoice is partially paid
    private Boolean partlyPaid;
    // partly payments
    private List<Payments> payments;
    // paid comulative
    private BigDecimal paidSum;
    /// view fields
    List<Output> tableList;
    Integer current;
    Integer tableListSize;

    public BigDecimal getPaidSum() {
        return paidSum;
    }

    public void setPaidSum(BigDecimal paidSum) {
        this.paidSum = paidSum;
    }

    public Input getInp() {
        return inp;
    }

    public void setInp(Input input) {
        this.inp = input;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getPartlyPaid() {
        return partlyPaid;
    }

    public void setPartlyPaid(Boolean partlyPaid) {
        this.partlyPaid = partlyPaid;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
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

    public List<Output> getTableList() {
        return tableList;
    }

    public void setTableList(List<Output> tableList) {
        this.tableList = tableList;
    }
}
