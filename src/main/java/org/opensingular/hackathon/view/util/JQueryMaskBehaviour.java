package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.*;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;

import java.util.List;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {

    @Override
    protected List<String> onDomReadyScript(Component ) {
        return ('.cep').mask('00000-000');
        return ('.cnpj').mask('00.000.000/0000-00');
        return List.of("$('.cep').mask('00000-000');");
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js");

    }
}

