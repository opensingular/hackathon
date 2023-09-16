package org.opensingular.hackathon.service;

import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepIntegracaoService {

    /**
     * <p>
     * Preencher utilizando o serviço do <a href="https://viacep.com.br/">Via Cep</a>
     *
     * <p>
     * Utilizar a classe {@link RestTemplate} do SpringFramework
     */

    public EnderecoDTO buscar(String cep) {

        var endereco = new EnderecoDTO();
        var template = new RestTemplate();
        endereco = template.getForObject("https://viacep.com.br/ws/" + cep + "/json", endereco.getClass());
        return endereco;
    }
}
