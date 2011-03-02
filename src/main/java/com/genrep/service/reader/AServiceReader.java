/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genrep.service.reader;

import com.genrep.codex.procedure.ClassificationProcedure;
import com.genrep.codex.service.ICodexService;
import com.genrep.warehouse.app.SalesAssistantApp;
import com.genrep.system.service.AppSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ristes
 */
public abstract class AServiceReader {

    protected ICodexService codexService;
    protected Map<String, String> map = new HashMap<String, String>();

    public void setCodexService(ICodexService codexService) {
        this.codexService = codexService;
    }

    public AServiceReader() {
    }

    public List get(String codexEntity) {
        try {
            return findAllByClassName(SalesAssistantApp.class.getName(), codexEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected List findAllByClassName(String className, String resultClassName) {
        try {
            List lst = new ArrayList();
            ClassificationProcedure opset = new ClassificationProcedure(className, "codexEntity");
            AppSystem.getLogger().info(Class.forName(resultClassName).toString());
            lst = opset.findAll(Class.forName(resultClassName));
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
