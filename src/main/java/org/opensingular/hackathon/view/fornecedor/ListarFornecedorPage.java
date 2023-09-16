package org.opensingular.hackathon.view.fornecedor;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.LambdaColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.opensingular.hackathon.entity.FornecedorEntity;
import org.opensingular.hackathon.service.FornecedorService;
import org.opensingular.hackathon.view.base.BasePage;
import org.opensingular.hackathon.view.util.SpringSortableDataProvider;

import java.util.ArrayList;
import java.util.List;

public class ListarFornecedorPage extends BasePage<Void> {

    @SpringBean
    private FornecedorService fornecedorService;

    public ListarFornecedorPage() {
        add(new AjaxFallbackDefaultDataTable<>("fornecedores", getColumns(), getDataProvider(), 10));
    }

    private List<IColumn<FornecedorEntity, String>> getColumns() {
        List<IColumn<FornecedorEntity, String>> cols = new ArrayList<>();
        cols.add(new LambdaColumn<>(new Model<>("CNPJ"), "cnpj", FornecedorEntity::getCnpj));
        cols.add(new LambdaColumn<>(new Model<>("Nome do contato"), "nomeDoContato", FornecedorEntity::getNomeDoContato));
        cols.add(new LambdaColumn<>(new Model<>("Razão social"), "razaoSocial", FornecedorEntity::getRazaoSocial));
        cols.add(new LambdaColumn<>(new Model<>("Email"), "emailContato", FornecedorEntity::getEmailContato));
        cols.add(new LambdaColumn<>(new Model<>("Atividades"), "atividades", FornecedorEntity::getAtividades));
        cols.add(new LambdaColumn<>(new Model<>("UF"), "endereco.uf", (f) -> f.getEndereco().getUf()));
        cols.add(new LambdaColumn<>(new Model<>("Localidade"), "endereco.localidade", (f) -> f.getEndereco().getLocalidade()));
        cols.add(newActionColumn());
        return cols;
    }

    private AbstractColumn<FornecedorEntity, String> newActionColumn() {
        return new AbstractColumn<>(new Model<>("Ações")) {
            @Override
            public void populateItem(Item<ICellPopulator<FornecedorEntity>> item, String componentId, IModel<FornecedorEntity> rowModel) {
                item.add(new EditarLink(componentId, rowModel));
            }
        };
    }

    private SpringSortableDataProvider<FornecedorEntity, Long> getDataProvider() {
        return new SpringSortableDataProvider<>() {
            @Override
            public FornecedorService getService() {
                return fornecedorService;
            }
        };
    }

    
}
