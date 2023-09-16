package org.opensingular.hackathon.view.util;


import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.ArrayList;
import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {

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
        return null;
    }


}
