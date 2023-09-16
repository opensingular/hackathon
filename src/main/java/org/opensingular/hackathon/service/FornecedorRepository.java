package org.opensingular.hackathon.service;

import org.opensingular.hackathon.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
    public default void findByCep(String cep){}
}
