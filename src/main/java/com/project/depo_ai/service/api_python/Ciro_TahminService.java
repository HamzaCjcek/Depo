package com.project.depo_ai.service.api_python;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.depo_ai.configuration.ApiConfig;
import com.project.depo_ai.model.veri_setleri.api_python.Ciro_TahminlerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class Ciro_TahminService {

    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    public Ciro_TahminService(ApiConfig apiConfig) {
        this.restTemplate = new RestTemplate();
        this.apiConfig = apiConfig;
    }

    public List<Ciro_TahminlerDto> getTahminler() {
        Map<String, Object> response = restTemplate.getForObject(apiConfig.getCiroUrl(), Map.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                response.get("ciro_tahminler"),
                new TypeReference<List<Ciro_TahminlerDto>>() {}
        );
    }

}
