/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.core;

import com.genrep.persistence.service.AEntity;
import java.math.BigDecimal;

/**
 *
 * @author kiril
 */
public class Output extends AEntity {

    private Input input;
    private Boolean paid;
    private BigDecimal paidPrice;

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }
}
