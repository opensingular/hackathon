package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.awt.*;
import java.util.List;


public class JQueryMaskBehaviour extends JQueryPluginBehavior {
    private String mascara;
    public JQueryMaskBehaviour (String mascara){
        this.mascara = mascara;
    }
    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

    }

    @Override
    protected List<String> onDomReadyScript(Component component) {
        return null;
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js");
    }


}
