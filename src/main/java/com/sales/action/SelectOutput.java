/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.container.service.application.AppFactory;
import com.genrep.guimodel.action.ARowAction;
import com.genrep.guimodel.gui.comp.table.Table;
import com.genrep.guimodel.mode.Mode;
import com.genrep.guimodel.service.gui.comp.AGUIContainer;
import com.genrep.system.service.AppSystem;
import com.sales.core.Input;
import com.sales.core.Output;
import com.warehouse.procedure.SalesAssistantProcedure;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kiril
 */
public class SelectOutput extends ARowAction {

    @Override
    public boolean doExecute() {
        Table searchTable = (Table) getParams()[0];
        AGUIContainer container = getContainer();
        Input bean = (Input) getRowItem();

        container.getContainer().doStore(false);
        String currentModeName = container.getActiveModeName();
        Mode mode = container.getMode(currentModeName);
        mode.setActive(false);
        Map containerParameters = container.getContainer().getContainerParameters();
        if (containerParameters != null) {
            List targetModeName = (List) containerParameters.get("returnMode");
            if (targetModeName != null && !targetModeName.isEmpty()) {
                mode = container.getMode((String) targetModeName.get(0));
                mode.setActive(true);
            } else {
                AppSystem.getLogger().error("PopUpListererCatalog|||TargetModeName is null.");
            }
        } else {
            AppSystem.getLogger().error("PopUpListererCatalog|||No container parameters found.");
        }

        Output resultContainerBean = (Output) container.getContainer().getContainerBean();

        SalesAssistantProcedure proc =
                new SalesAssistantProcedure(AppFactory.getCurrentApplication().getName(), "codexEntity");
        List<Output> chlist = proc.checkIfPartlyPaid(bean.getUID());

        Boolean fullyPaid = Boolean.TRUE;

        if (chlist != null && !chlist.isEmpty()) {
            fullyPaid = Boolean.FALSE;
        }

        if (fullyPaid) {
            resultContainerBean.setInp(bean);
        } else {
            container.getContainer().setContainerBean(chlist.get(0));
        }
        container.getContainer().doLoad();
        searchTable.setValue(null);
        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.LOAD;
    }
}
