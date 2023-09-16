package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessagesModel;
import org.apache.wicket.markup.head.*;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior{

    private String mask;
    public JQueryMaskBehaviour(String mask){
        this.mask = mask;
    }
    @Override
    protected List<String> onDomReadyScript(Component component) {
        List<String> scripts = new ArrayList<>();
        scripts.add("$('#" + component.getMarkupId(true) + "').mask('" + mask + "')");
        return scripts;
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js");
    }

}
