/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.container.service.application.AppFactory;
import com.genrep.guimodel.gui.comp.checkBox.CheckBox;
import com.genrep.guimodel.gui.comp.combo.Combo;
import com.genrep.guimodel.gui.comp.table.Table;
import com.genrep.guimodel.gui.comp.text.Text;
import com.genrep.guimodel.service.action.AAction;
import com.sales.core.Organization;
import com.warehouse.operationset.SalesAssistantOperationSet;
import java.util.Date;

/**
 *
 * @author Kiril Arsov
 */
public class SearchOutput extends AAction {

    @Override
    public boolean doExecute() {
        CheckBox paids = (CheckBox) getParams()[0];
        Boolean paid = (Boolean) paids.getValueObject();
        if (paid == null) {
            paid = Boolean.FALSE;
        }


        CheckBox partlyPaids = (CheckBox) getParams()[1];
        Boolean partlyPaid = (Boolean) partlyPaids.getValueObject();
        if (partlyPaid == null) {
            partlyPaid = Boolean.FALSE;
        }
        Text invoiceNumbers = (Text) getParams()[2];
        String invoiceNumber = (String) invoiceNumbers.getValueObject();

        Combo itemcom = (Combo) getParams()[3];
        Organization org = (Organization) itemcom.getValueObject();
        String orgName = null;
        if (org != null) {
            orgName = (String) org.getName();
        }

        Table table = (Table) getParams()[4];

        SalesAssistantOperationSet proc = new SalesAssistantOperationSet(AppFactory.getCurrentApplication().getName(), "codexSession");
        table.setValue(proc.findOutput(paid, partlyPaid, invoiceNumber, orgName));
        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
