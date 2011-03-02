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
import com.sales.core.Input;
import com.sales.core.Output;
import com.warehouse.core.Individual;
import com.warehouse.core.Organization;
import com.warehouse.procedure.SalesAssistantProcedure;

/**
 *
 * @author Kiril Arsov
 */
public class AddNewOrganization extends AAction {

    @Override
    public boolean doExecute() {
        if (getContainer().getContainerBean().getClass().equals(Input.class)) {
            Input in = (Input) getContainer().getContainerBean();
            Object[] params = getParams();
            Text text = (Text) params[0];
            Combo combo = (Combo) params[1];
            String newItemName = (String) text.getValueObject();
            Organization newOrganization = new Organization();

            newOrganization.setName(newItemName);
            SalesAssistantProcedure proc = new SalesAssistantProcedure(AppFactory.getCurrentApplication().getName(), "codexSession");
            ISaveable saveable = (ISaveable) newOrganization;

            saveable.setCommitTransaction(true);

            newOrganization.save(proc);

            in.setOrganization(newOrganization);
            text.setValueObject(null);
            combo.init();
        } else if (getContainer().getContainerBean().getClass().equals(Output.class)) {
            Output out = (Output) getContainer().getContainerBean();
            Object[] params = getParams();
            Text text = (Text) params[0];
            Combo combo = (Combo) params[1];
            String newItemName = (String) text.getValueObject();
            Individual newIndividual = new Individual();

            newIndividual.setName(newItemName);
            SalesAssistantProcedure proc = new SalesAssistantProcedure(AppFactory.getCurrentApplication().getName(), "codexSession");
            ISaveable saveable = (ISaveable) newIndividual;

            saveable.setCommitTransaction(true);

            newIndividual.save(proc);

//            out.setIndividual(newIndividual);
            text.setValueObject(null);
            combo.init();
        }

        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;

    }
}
