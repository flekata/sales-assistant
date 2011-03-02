/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.procedure;

import com.genrep.operationset.service.exception.OperationSetException;
import com.genrep.operationset.service.procedure.IProcedure;
import com.genrep.operationset.service.procedure.ISaveable;
import com.warehouse.operationset.SalesAssistantOperationSet;


/**
 *
 * @author user1
 */
public class SalesAssistantProcedure extends SalesAssistantOperationSet implements IProcedure {

    public SalesAssistantProcedure(String appClassName, String sessName) {
        super(appClassName, sessName);
    }

    public void save(ISaveable saveable, boolean closeSessionOnError) throws OperationSetException {
        setCloseSessionOnError(closeSessionOnError);
        try {
            saveOrUpdate(saveable);
        } catch (OperationSetException ose) {
            ose.printStackTrace();
//            getLogger().error(ose.getMessage());
        }
    }
    @Override
    public void saveNew(ISaveable saveable, boolean closeSessionOnError) throws OperationSetException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
