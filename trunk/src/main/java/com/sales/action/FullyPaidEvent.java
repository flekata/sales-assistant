/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.guimodel.action.AValueChangeEvent;
import com.genrep.guimodel.gui.comp.checkBox.CheckBox;
import com.genrep.guimodel.gui.comp.text.OutputText;
import com.sales.core.Output;
import com.sales.core.Payments;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiril
 */
public class FullyPaidEvent extends AValueChangeEvent {
    
    @Override
    public boolean doExecute() {
        OutputText ot = (OutputText) getParams()[0];
        Output output = (Output) getContainer().getContainerBean();
        CheckBox chbox = (CheckBox) getInvoker();
        Boolean fullyPaid = (Boolean) chbox.getValueObject();
        if (fullyPaid != null) {
            if (fullyPaid) {
                List<Payments> pym = new ArrayList<Payments>();
                Payments p = new Payments();
                p.setDate(output.getDate());
                p.setValue(output.getInp().getPrice());
                pym.add(p);
                output.setPayments(pym);
                ot.setValue(output.getInp().getPrice());
                output.setPaidSum(output.getInp().getPrice());
            } else {
                ot.setValue(null);
                output.setPaidSum(null);
            }
        }
        
        return true;
    }
    
    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
