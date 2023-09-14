package org.opensingular.hackathon.view.fornecedor;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.opensingular.hackathon.entity.FornecedorEntity;

public class EditarLink extends Panel {
    public EditarLink(String id, IModel<FornecedorEntity> model) {
        super(id, model);
        add(new Link<>("action", model) {
            @Override
            public void onClick() {
                setResponsePage(EditarFornecedorPage.class, new PageParameters().set("id", getModelObject().getId()));
            }
        });
    }
}