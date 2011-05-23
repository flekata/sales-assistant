/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.beans;

import com.genrep.persistence.service.AEntity;
import com.sales.core.Input;

/**
 *
 * @author kiril
 */
public class BalanceTableColumns extends AEntity {

    private Input input;
    private Boolean fullPaid;
    private Boolean partlyPaid = true;

    public Boolean getFullPaid() {
        return fullPaid;
    }

    public void setFullPaid(Boolean fullPaid) {
        this.fullPaid = fullPaid;
    }

    public Boolean getPartlyPaid() {
        return partlyPaid;
    }

    public void setPartlyPaid(Boolean partlyPaid) {
        this.partlyPaid = partlyPaid;
    }
}
