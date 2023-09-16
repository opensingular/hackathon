package org.opensingular.hackathon.service;

import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
        var restTemplate = new RestTemplate();
        ResponseEntity<EnderecoDTO> forEntity = restTemplate.getForEntity("https://viacep.com.br/ws/" + cep +"/json/", EnderecoDTO.class);
        return forEntity.getBody();
    }
}
