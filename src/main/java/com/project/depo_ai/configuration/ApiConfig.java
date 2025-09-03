package com.project.depo_ai.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Value("${api.base-url}")
    private String baseUrl;

    public String getTahminlerUrl() {
        return baseUrl + "/tahminler/";
    }
    public String getForecastUrl() {
        return baseUrl + "/forecast/";
    }
    public String getCiroUrl() {
        return baseUrl + "/ciro/";
    }
    public String getChatUrl() {
        return baseUrl + "/chat/";
    }

}