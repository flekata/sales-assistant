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
import com.sales.core.Input;
import com.sales.core.Organization;
import com.warehouse.procedure.SalesAssistantProcedure;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kiril
 */
public class OutputSearchFiltered extends AAction {

    @Override
    public boolean doExecute() {
        List resultList = new ArrayList();
        Object[] params = getParams();
        Table searchTable = (Table) params[0];
        DateComp datcomp = (DateComp) getContainer().getComponents().get("fwspinputpopup_date");
        Date fdate = (Date) datcomp.getValueObject();
        Text itext2 = (Text) getContainer().getComponents().get("fwspinputpopup_invoiceNumber");
        String finvoiceNumber = (String) itext2.getValueObject();
        Combo itext3 = (Combo) getContainer().getComponents().get("fwspinputpopup_organization");
        Organization org = (Organization) itext3.getValueObject();
        org = (Organization) AppFactory.getSessionManagerImpl().getObjectImpl(org);
        String orgName = null;
        if (org != null) {
            orgName = org.getName();
        }
        SalesAssistantProcedure proc =
                new SalesAssistantProcedure(AppFactory.getCurrentApplication().getName(), "codexEntity");
        List notBalanced = proc.getInputNotBalanced();
        if (notBalanced != null) {
            int size = notBalanced.size();
            for (int i = 0; i < size; i++) {
                Input in = (Input) proc.getInputByUid((String) notBalanced.get(i));

                in = (Input) AppFactory.getSessionManagerImpl().getObjectImpl(in);
                boolean add = true;
                if (fdate != null && fdate.compareTo(in.getDate()) != 0) {
                    add = false;
                }
                if (finvoiceNumber != null && !finvoiceNumber.equalsIgnoreCase(in.getInvoiceNumber())) {
                    add = false;
                }
                if (orgName != null && in.getOrganization() != null && !orgName.equalsIgnoreCase(in.getOrganization().getName())) {
                    add = false;
                }
                if (add) {
                    resultList.add(in);
                }

            }

        }

        List partlyPaid = proc.findInputFiltered(
                (Date) datcomp.getValueObject(),
                (String) itext2.getValueObject(),
                orgName);

        if (partlyPaid != null) {
            resultList.addAll(partlyPaid);
        }


        searchTable.setValueObject(resultList);
        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
