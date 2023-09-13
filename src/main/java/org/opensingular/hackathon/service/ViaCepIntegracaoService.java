package org.opensingular.hackathon.service;

import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
        try {
            var template = new RestTemplate();
            return template.getForObject(getViaCepUrl(cep), EnderecoDTO.class);
        } catch (RestClientException e) {
            return null;
        }
    }

    private String getViaCepUrl(String cep) {
        return String.format("https://viacep.com.br/ws/%s/json/", cep);
    }

}
