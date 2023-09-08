package org.opensingular.hackathon.view.fornecedor;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.opensingular.hackathon.entity.FornecedorEntity;
import org.opensingular.hackathon.service.FornecedorService;
import org.opensingular.hackathon.view.base.BasePage;

public class EditarFornecedorPage extends BasePage<FornecedorEntity> {

    @SpringBean
    private FornecedorService fornecedorService;

    private WebMarkupContainer enderecoGroup;

    public EditarFornecedorPage(PageParameters parameters) {
        super(parameters);

        FornecedorEntity fornecedor = null;

        Long id = parameters.get("id").toOptionalLong();
        if (id != null) {
            fornecedor = fornecedorService.findById(id).orElse(null);
        }

        if (fornecedor == null) {
            fornecedor = new FornecedorEntity();
        }

        setModel(new CompoundPropertyModel<>(fornecedor));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        Form<FornecedorEntity> form;
        add(form = newFornecedorForm());

        form.add(newSuccessMessages());

        WebMarkupContainer dadosGeraisGroup;
        form.add(dadosGeraisGroup = new WebMarkupContainer("dadosGerais"));
        dadosGeraisGroup.queue(new TextField<>("razaoSocial"));
        dadosGeraisGroup.queue(new TextField<>("cnpj"));
        dadosGeraisGroup.queue(new TextField<>("emailContato"));
        dadosGeraisGroup.queue(new TextArea<>("atividades"));

        form.add(enderecoGroup = new WebMarkupContainer("endereco"));
        enderecoGroup.add(new TextField<>("endereco.cep").add(newBuscarPorCep()));
        enderecoGroup.add(new TextField<>("endereco.logradouro"));
        enderecoGroup.add(new TextField<>("endereco.uf"));
        enderecoGroup.add(new TextField<>("endereco.localidade"));
        enderecoGroup.add(new TextField<>("endereco.bairro"));
        enderecoGroup.add(new TextArea<>("endereco.complemento"));
    }

    private Component newSuccessMessages() {
        return new FeedbackPanel("successMessages", FeedbackMessage::isSuccess) {
            @Override
            public boolean isVisible() {
                return anyMessage();
            }
        };
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        enderecoGroup.setOutputMarkupId(true);
    }

    private AjaxFormComponentUpdatingBehavior newBuscarPorCep() {
        return new AjaxFormComponentUpdatingBehavior("change") {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                fornecedorService.carregarPorCep(getModelObject().getEndereco());
                //Aqui está faltando um comando para forçar a atualização da página, dica:
                //https://nightlies.apache.org/wicket/guide/9.x/single.html#_how_to_use_ajax_components_and_behaviors
            }
        };
    }

    private Form<FornecedorEntity> newFornecedorForm() {
        return new Form<>("form", getModel()) {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                fornecedorService.save(getModelObject());
                success("Dados salvos com sucesso!");
            }
        };
    }
}