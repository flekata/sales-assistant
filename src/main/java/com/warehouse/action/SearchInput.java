/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.action;

import com.genrep.container.service.application.AppFactory;
import com.genrep.guimodel.gui.comp.combo.Combo;
import com.genrep.guimodel.gui.comp.date.DateComp;
import com.genrep.guimodel.gui.comp.table.Table;
import com.genrep.guimodel.gui.comp.text.Text;
import com.genrep.guimodel.service.action.AAction;
import com.warehouse.core.Item;
import com.warehouse.core.Warehouse;
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
        Item item = (Item) itemcom.getValueObject();
        String itemname = null;
        if (item != null) {
            itemname = (String) item.getName();
        }


        Combo itemwar = (Combo) getParams()[1];
        Warehouse war = (Warehouse) itemwar.getValueObject();
        String warname = null;
        if (war != null) {
            warname = war.getName();
        }

        Text sizetx = (Text) getParams()[2];
        String size = (String) sizetx.getValueObject();
        Integer siz = null;
        if (size != null) {
            siz = new Integer(size);
        }
        
        Text pricecdtx = (Text) getParams()[3];
        String price = (String) pricecdtx.getValueObject();
        BigDecimal pr = null;
        if (price != null) {
            pr = new BigDecimal(price);
        }

//        DateComp datecdtx = (DateComp) getParams()[4];
//        Date datecd = (Date)datecdtx.getValueObject();
        Date datecd = null;
        Table table = (Table) getParams()[4];

        SalesAssistantOperationSet proc = new SalesAssistantOperationSet(AppFactory.getCurrentApplication().getName(), "codexSession");
        table.setValue(proc.findInput(itemname, warname, siz, pr, datecd));

        return true;
    }

    @Override
    public ActionType getType() {
        return ActionType.BOTH;
    }
}
