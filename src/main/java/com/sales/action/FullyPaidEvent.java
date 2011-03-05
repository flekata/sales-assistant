/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.guimodel.action.AValueChangeEvent;
import com.genrep.guimodel.gui.comp.checkBox.CheckBox;
import com.genrep.guimodel.gui.comp.text.OutputText;
import com.sales.core.Output;

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
