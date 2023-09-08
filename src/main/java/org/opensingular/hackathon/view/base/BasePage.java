package org.opensingular.hackathon.view.base;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

public abstract class BasePage<T> extends GenericWebPage<T> {

    public BasePage() {
    }

    public BasePage(IModel<T> model) {
        super(model);
    }

    public BasePage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssReferenceHeaderItem.forUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"));
        response.render(JavaScriptReferenceHeaderItem.forUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"));
        response.render(CssReferenceHeaderItem.forReference(new PackageResourceReference(BasePage.class, "BasePage.css")));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new HeaderResponseContainer("footer-container", "footer-container"));
    }
}
