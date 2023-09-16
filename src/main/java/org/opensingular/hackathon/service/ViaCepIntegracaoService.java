package org.opensingular.hackathon.service;

import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

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

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EnderecoDTO> responseEntity = restTemplate.getForEntity("https://viacep.com.br/ws/01001000/json/", EnderecoDTO.class);

        return responseEntity.getBody();
    }

}
