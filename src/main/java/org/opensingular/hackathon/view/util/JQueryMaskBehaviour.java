package org.opensingular.hackathon.view.util;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.*;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JQueryMaskBehaviour extends Behavior {

    public static final String MASK_MIN_URL = "https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js";
    @Language("js")
    private String mask;

    public JQueryMaskBehaviour(@Language("js") String mask) {
        this.mask = mask;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        response.render(JavaScriptReferenceHeaderItem.forUrl(MASK_MIN_URL));
        response.render(OnDomReadyHeaderItem.forScript(getMaskScript(component.getMarkupId())));
    }

    @NotNull
    private static UrlResourceReference getMaskPluginReference() {
        return new UrlResourceReference(Url.parse(MASK_MIN_URL)) {
            @Override
            public List<HeaderItem> getDependencies() {
                Application application = Application.get();
                ResourceReference jqueryRef = application.getJavaScriptLibrarySettings().
                        getJQueryReference();

                return List.of(JavaScriptHeaderItem.forReference(jqueryRef));
            }
        };
    }

    @Language("js")
    public String getMaskScript(@Language("js") String componentId) {
        return " $('#" + componentId + "').mask('" + mask + "');";
    }


}
