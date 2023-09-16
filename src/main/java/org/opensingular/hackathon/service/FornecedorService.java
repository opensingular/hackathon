package org.opensingular.hackathon.service;

import org.opensingular.hackathon.entity.EnderecoEntity;
import org.opensingular.hackathon.entity.FornecedorEntity;
import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FornecedorService implements CRUDService<FornecedorEntity, Long> {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ViaCepIntegracaoService viaCepIntegracaoService;

    @Override
    public FornecedorRepository getRepository() {
        return fornecedorRepository;
    }

    /**
     * Preencher os dados da entidade com os dados retornados no serviço
     */
    public void carregarPorCep(EnderecoEntity endereco) {
        EnderecoDTO dto = viaCepIntegracaoService.buscar(endereco.getCep());
        endereco.setBairro(dto.getBairro());
        endereco.setComplemento(dto.getComplemento());
        endereco.setLocalidade(dto.getLocalidade());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setUf(dto.getUf());
    }
}


