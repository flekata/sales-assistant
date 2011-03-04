/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.action;

import com.genrep.guimodel.service.action.AAction;

/**
 *
 * @author Kiril Arsov
 */
public class BothAction extends AAction {

    @Override
    public boolean doExecute() {
        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
