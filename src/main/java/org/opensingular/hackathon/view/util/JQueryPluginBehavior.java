package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.*;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;

import java.util.Collections;
import java.util.List;

public abstract class JQueryPluginBehavior extends Behavior {

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        for (String script : getPluginScripts()) {
            response.render(JavaScriptHeaderItem.forReference(new UrlResourceReference(Url.parse(script)) {
                @Override
                public List<HeaderItem> getDependencies() {
                    return List.of(JavaScriptHeaderItem.forReference(component.getApplication().getJavaScriptLibrarySettings().getJQueryReference()));
                }
            }));
        }
        for (String style : getPluginStyles()) {
            response.render(CssReferenceHeaderItem.forUrl(style));
        }
        for (String script : onDomReadyScript(component)) {
            response.render(OnDomReadyHeaderItem.forScript(script));
        }
    }

    protected abstract List<String> onDomReadyScript(Component component);

    protected abstract List<String> getPluginScripts();

    protected List<String> getPluginStyles() {
        return Collections.emptyList();
    }

}
