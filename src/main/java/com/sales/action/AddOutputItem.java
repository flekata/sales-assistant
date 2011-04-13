/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.guimodel.action.AddAction;
import com.genrep.guimodel.gui.comp.checkBox.CheckBox;
import com.genrep.guimodel.gui.comp.text.OutputText;
import com.genrep.guimodel.service.gui.comp.AGUIContainer;
import com.sales.core.Output;
import com.sales.core.Payments;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiril
 */
public class AddOutputItem extends AddAction {

    public boolean doExecute() {
        AGUIContainer container = getContainer();
        Boolean editMode = (Boolean) getContainer().getContainerParameters().get("iteratorEditMode");
        if (editMode != null) {
            if (editMode) {
                return super.doExecute();
            }
        }
        Payments payments = (Payments) container.getContainerBean();



        Output output = (Output) container.getContainer().getContainerBean();


        List<Payments> lst = (List<Payments>) output.getPayments();


        if (lst == null) {
            lst = new ArrayList();
            output.setPayments(lst);
        }
        lst.add(payments);
        BigDecimal sum = new BigDecimal("0.0");

        for (int i = 0; i < lst.size(); i++) {
            Payments pay = lst.get(i);
            sum = sum.add(pay.getValue());
        }
        CheckBox chboxpaid = (CheckBox) container.getContainer().getComponents().get("paid");
        CheckBox chboxpartlypaid = (CheckBox) container.getContainer().getComponents().get("partlyPaid");
        OutputText ot = (OutputText) container.getContainer().getComponents().get("paidSumout");
        OutputText amountToBePaid = (OutputText) container.getContainer().getComponents().get("amountToBePaid");
        amountToBePaid.setValue(output.getInp().getPrice().subtract(sum));
        if (output.getInp().getPrice().compareTo(sum) <= 0) {
            output.setPartlyPaid(false);
            chboxpartlypaid.setValue(Boolean.FALSE);
            output.setPaid(true);
            chboxpaid.setValue(Boolean.TRUE);
            output.setPaidSum(sum);
            ot.setValue(sum);
        }
        container.clearContainerBean();
        container.clearContainer();
        return true;

    }

    @Override
    public ActionType getType() {
        return ActionType.STORE;
    }

    @Override
    public List<ActionType> getTypes() {
        List<ActionType> types = new ArrayList<ActionType>();
        types.add(ActionType.STORE);
        types.add(ActionType.CLONE_TO_ENTITY);
        return types;
    }
}
