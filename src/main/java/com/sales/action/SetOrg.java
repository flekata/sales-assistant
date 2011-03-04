/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.container.service.application.AppFactory;
import com.genrep.guimodel.gui.comp.combo.Combo;
import com.genrep.guimodel.service.action.AAction;
import com.sales.core.Input;
import com.sales.core.Organization;

/**
 *
 * @author kiril
 */
public class SetOrg extends AAction {

    @Override
    public boolean doExecute() {
        Input input = (Input) getContainer().getContainerBean();
        Combo combo = (Combo) getInvoker();
        Organization org = (Organization) combo.getValueObject();
        org = (Organization) AppFactory.getSessionManagerImpl().getObjectImpl(org);
        input.setOrganization(org);
        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
