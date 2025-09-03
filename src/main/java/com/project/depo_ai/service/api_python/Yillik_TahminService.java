package com.project.depo_ai.service.api_python;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.depo_ai.configuration.ApiConfig;
import com.project.depo_ai.model.veri_setleri.api_python.StokTahminDto;
import com.project.depo_ai.model.veri_setleri.api_python.Yillik_TahminlerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class Yillik_TahminService {

    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    public Yillik_TahminService(ApiConfig apiConfig) {
        this.restTemplate = new RestTemplate();
        this.apiConfig = apiConfig;
    }

    public List<Yillik_TahminlerDto> getTahminler() {
        // API'den JSON objesini Map olarak çek
        Map<String, Object> response = restTemplate.getForObject(apiConfig.getForecastUrl(), Map.class);

        // Map içinden "yillik_tahminler" array’ini al ve DTO’ya dönüştür
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                response.get("yillik_tahminler"),
                new TypeReference<List<Yillik_TahminlerDto>>() {}
        );
    }
}
