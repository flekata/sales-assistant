/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.container.service.application.AppFactory;
import com.genrep.guimodel.gui.comp.combo.Combo;
import com.genrep.guimodel.gui.comp.text.Text;
import com.genrep.guimodel.service.action.AAction;
import com.genrep.operationset.service.procedure.ISaveable;
import com.warehouse.core.Bank;
import com.warehouse.core.Organization;
import com.warehouse.procedure.SalesAssistantProcedure;

/**
 *
 * @author Kiril Arsov
 */
public class AddNewBank extends AAction {

    @Override
    public boolean doExecute() {

        Organization in = (Organization) getContainer().getContainerBean();
        Object[] params = getParams();
        Text text = (Text) params[0];
        Combo combo = (Combo) params[1];
        String newItemName = (String) text.getValueObject();
        Bank newOrganization = new Bank();

        newOrganization.setName(newItemName);
        SalesAssistantProcedure proc = new SalesAssistantProcedure(AppFactory.getCurrentApplication().getName(), "codexSession");
        ISaveable saveable = (ISaveable) newOrganization;

        saveable.setCommitTransaction(true);

        newOrganization.save(proc);

        in.setBank(newOrganization);
        text.setValueObject(null);
        combo.init();

        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.STORE;

    }
}
