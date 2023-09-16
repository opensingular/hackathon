package org.opensingular.hackathon.service;

import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.http.HttpMethod;
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
    public EnderecoDTO buscar(String cep) throws URISyntaxException {

        URI uri = new URI("https://viacep.com.br/");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(uri, Employee[].class);




        return new EnderecoDTO();
    }



    //exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables)
}
