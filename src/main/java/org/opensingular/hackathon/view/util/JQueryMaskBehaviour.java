package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;

import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {

    public static final String MASK_MIN_URL = "https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js";
    private String mask;

    public JQueryMaskBehaviour(String mask) {
        this.mask = mask;
    }

    @Override
    protected List<String> onDomReadyScript(Component component) {
        return List.of(getMaskScript(component.getMarkupId()));
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of(MASK_MIN_URL);
    }

    public String getMaskScript(String componentId) {
        return " $('#" + componentId + "').mask('" + mask + "');";
    }

}
