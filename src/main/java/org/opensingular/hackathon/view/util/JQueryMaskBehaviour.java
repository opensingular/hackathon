package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;

import java.util.ArrayList;
import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {
    private String mask;
    public JQueryMaskBehaviour(String mask) {
        this.mask = mask;
    }

    @Override
    protected List<String> onDomReadyScript(Component component) {
        List<String> scripts = new ArrayList<>();
        scripts.add("$('#" + component.getMarkupId() +"').mask('" + mask + "')" );
        return scripts;
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js");
    }
}
