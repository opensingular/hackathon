package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnEventHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.ArrayList;
import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {
    @Override
    protected List<String> onDomReadyScript(Component component) {
        "" + "$(component.getMarkupId())"
        return component.getMarkupId();
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js");
    }


//        $(document).ready(function(){
//            $('.cep').mask('00000-000');
//            $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
//        });
}
