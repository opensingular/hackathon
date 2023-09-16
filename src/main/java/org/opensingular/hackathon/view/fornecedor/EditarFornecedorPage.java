package org.opensingular.hackathon.view.fornecedor;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.jetbrains.annotations.NotNull;
import org.opensingular.hackathon.entity.FornecedorEntity;
import org.opensingular.hackathon.service.FornecedorService;
import org.opensingular.hackathon.view.base.BasePage;
import org.opensingular.hackathon.view.util.JQueryMaskBehaviour;
import org.opensingular.hackathon.view.util.SweetAlertFeedbackBehaviour;

public class EditarFornecedorPage extends BasePage<FornecedorEntity> {

    @SpringBean
    private FornecedorService fornecedorService;

    private Form<FornecedorEntity> form;

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

        add(form = new Form<>("form", getModel()));
        form.add(new SweetAlertFeedbackBehaviour());

        WebMarkupContainer dadosGeraisGroup;
        form.add(dadosGeraisGroup = new WebMarkupContainer("dadosGerais"));
        dadosGeraisGroup.queue(new TextField<>("nomeContato"));
        dadosGeraisGroup.queue(new TextField<>("razaoSocial"));
        dadosGeraisGroup.queue(new TextField<>("cnpj").add(new JQueryMaskBehaviour("00.000.000/0000-00")));
        dadosGeraisGroup.queue(new TextField<>("emailContato"));
        dadosGeraisGroup.queue(new TextArea<>("atividades"));

        form.add(enderecoGroup = new WebMarkupContainer("endereco"));
        enderecoGroup.setOutputMarkupId(true);
        enderecoGroup.add(new TextField<>("endereco.cep").add(new JQueryMaskBehaviour("00000-000")).add(newBuscarPorCep()));
        enderecoGroup.add(new TextField<>("endereco.logradouro"));
        enderecoGroup.add(new TextField<>("endereco.uf"));
        enderecoGroup.add(new TextField<>("endereco.localidade"));
        enderecoGroup.add(new TextField<>("endereco.bairro"));
        enderecoGroup.add(new TextArea<>("endereco.complemento"));

        form.add(newSubmitButton());
    }

    @NotNull
    private Button newSubmitButton() {
        return new Button("submit") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                fornecedorService.save(form.getModelObject());
                form.success("Dados salvos com sucesso!");
            }
        };
    }

    private AjaxFormComponentUpdatingBehavior newBuscarPorCep() {
        return new AjaxFormComponentUpdatingBehavior("change") {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                fornecedorService.carregarPorCep(getModelObject().getEndereco());
                target.add(enderecoGroup);
                //Aqui está faltando um comando para forçar a atualização da página, dica:
                //https://nightlies.apache.org/wicket/guide/9.x/single.html#_how_to_use_ajax_components_and_behaviors
            }
        };
    }
}