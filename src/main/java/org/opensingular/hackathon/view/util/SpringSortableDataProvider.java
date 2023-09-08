package org.opensingular.hackathon.view.util;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.opensingular.hackathon.service.CRUDService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Iterator;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

public abstract class SpringSortableDataProvider<T extends Serializable, ID> extends SortableDataProvider<T, String> {

    public abstract CRUDService<T, ID> getService();

    protected String getSortProperty() {
        return getSort().getProperty();
    }

    protected Sort.Direction getSortDirection() {
        return getSort().isAscending() ? ASC : DESC;
    }

    protected PageRequest toPageRequest(long first, long count) {
        return PageRequest.of((int) first, (int) count, Sort.by(getSortDirection(), getSortProperty()));
    }

    @Override
    public final Iterator<T> iterator(long first, long count) {
        return getService()
                .findAll(toPageRequest(first, count))
                .iterator();
    }

    @Override
    public final long size() {
        return getService().count();
    }

    @Override
    public IModel<T> model(T object) {
        return Model.of(object);
    }

    @Override
    public SortParam<String> getSort() {
        SortParam<String> sort = super.getSort();
        if (sort == null) {
            return new SortParam<>("id", true);
        }
        return sort;
    }
}
