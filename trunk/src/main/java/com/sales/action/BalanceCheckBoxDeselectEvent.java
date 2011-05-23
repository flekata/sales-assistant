/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.guimodel.action.AValueChangeEvent;
import com.genrep.guimodel.gui.comp.checkBox.CheckBox;
import com.sales.beans.BalanceTableColumns;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author kiril
 */
public class BalanceCheckBoxDeselectEvent extends AValueChangeEvent {

    @Override
    public boolean doExecute() {
        BalanceTableColumns bean = (BalanceTableColumns) getContainer().getContainerBean();
        if (getInvoker().getId().contains("partly")) {
            bean.setPartlyPaid(Boolean.TRUE);
            bean.setFullPaid(Boolean.FALSE);
        } else {
            bean.setPartlyPaid(Boolean.FALSE);
            bean.setFullPaid(Boolean.TRUE);
        }
        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
