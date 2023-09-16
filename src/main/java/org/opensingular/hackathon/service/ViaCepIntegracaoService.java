package org.opensingular.hackathon.service;

import org.opensingular.hackathon.entity.EnderecoEntity;
import org.opensingular.hackathon.entity.FornecedorEntity;
import org.opensingular.hackathon.model.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepIntegracaoService {




    /**
     * <p>
     * Preencher utilizando o serviço do <a href="https://viacep.com.br/">Via Cep</a>
     *
     *
     * <p>
     * Utilizar a classe {@link RestTemplate} do SpringFramework
     */
    public EnderecoDTO buscar(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws//json/";
        ResponseEntity< EnderecoDTO> responseEntity = restTemplate.getForEntity(url,EnderecoDTO.class);


        return responseEntity.getBody();
    }
}
