package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;

import java.util.ArrayList;
import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {

    private String mascara;

    public JQueryMaskBehaviour(String mascara) {
        this.mascara = mascara;
    }
    @Override
    protected List<String> onDomReadyScript(Component component) {
        List<String> scripts = new ArrayList<>();
        scripts.add("$('#" + component.getMarkupId() + "')" + ".mask('" + mascara + "')");
        return scripts;
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js");
    }


}
