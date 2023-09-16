package org.opensingular.hackathon.service;

import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ViaCepIntegracaoService> responseEntity = restTemplate.postForEntity("viacep.com.br/ws/01001000/json/", cep, ViaCepIntegracaoService.class);
        return new EnderecoDTO();
    }
}
   
