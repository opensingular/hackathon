package org.opensingular.hackathon.config;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.opensingular.hackathon.view.fornecedor.EditarFornecedorPage;
import org.opensingular.hackathon.view.fornecedor.ListarFornecedorPage;
import org.springframework.stereotype.Component;

@Component
public class WicketApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return ListarFornecedorPage.class;
    }

    @Override
    protected void init() {
        super.init();
        setUpCsp();
        setUpPages();
        setUpString();
    }

    private void setUpString() {
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

    private void setUpPages() {
        mountPage("/", ListarFornecedorPage.class);
        mountPage("/fornecedor", EditarFornecedorPage.class);
    }

    private void setUpCsp() {
        getCspSettings().blocking().disabled();
    }
}
