package com.project.depo_ai.service.api_python;

import com.project.depo_ai.configuration.ApiConfig;
import com.project.depo_ai.model.veri_setleri.api_python.StokTahminDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StokTahminService {

    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    public StokTahminService(ApiConfig apiConfig) {
        this.restTemplate = new RestTemplate();
        this.apiConfig = apiConfig;
    }

    public List<StokTahminDto> getTahminler() {
        StokTahminDto[] response = restTemplate.getForObject(apiConfig.getTahminlerUrl(), StokTahminDto[].class);
        return Arrays.asList(response);
    }
}