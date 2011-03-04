/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.container.service.application.AppFactory;
import com.genrep.guimodel.gui.comp.combo.Combo;
import com.genrep.guimodel.gui.comp.date.DateComp;
import com.genrep.guimodel.gui.comp.table.Table;
import com.genrep.guimodel.gui.comp.text.Text;
import com.genrep.guimodel.service.action.AAction;
import com.sales.core.Organization;
import com.warehouse.operationset.SalesAssistantOperationSet;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Kiril Arsov
 */
public class SearchInput extends AAction {

    @Override
    public boolean doExecute() {
        Combo itemcom = (Combo) getParams()[0];
        Organization org= (Organization) itemcom.getValueObject();
        String orgName = null;
        if (org != null) {
            orgName = (String) org.getName();
        }


        DateComp dat = (DateComp) getParams()[1];
        Date date = (Date) dat.getValueObject();


        Text invoiceNumbers = (Text) getParams()[2];
        String invoiceNumber = (String) invoiceNumbers.getValueObject();

        Date datecd = null;
        Table table = (Table) getParams()[3];

        SalesAssistantOperationSet proc = new SalesAssistantOperationSet(AppFactory.getCurrentApplication().getName(), "codexSession");
        table.setValue(proc.findInput(orgName, date, invoiceNumber));

        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
