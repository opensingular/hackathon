package org.opensingular.hackathon.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CRUDService<T, ID> {
    default Iterable<T> findAll(PageRequest pageRequest) {
        return getRepository().findAll(pageRequest);
    }

    default long count() {
        return getRepository().count();
    }

    default Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    default void save(T entity) {
        getRepository().save(entity);
    }

    JpaRepository<T, ID> getRepository();

}
