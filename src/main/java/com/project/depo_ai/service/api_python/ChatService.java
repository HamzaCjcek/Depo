package com.project.depo_ai.service.api_python;
import com.project.depo_ai.configuration.ApiConfig;
import com.project.depo_ai.model.veri_setleri.ai.chat;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    public ChatService(RestTemplateBuilder builder, ApiConfig apiConfig) {
        this.restTemplate = builder.build();
        this.apiConfig = apiConfig;
    }

    public chat getChatAnswer(String soru) {
        chat request = new chat();
        request.set_soru(soru);  // Kullanıcı sorusunu gönder

        // FastAPI chat endpoint’i
        String url = apiConfig.getChatUrl();

        // JSON header ile POST request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<chat> entity = new HttpEntity<>(request, headers);

        // Tek JSON cevap al
        return restTemplate.postForObject(url, entity, chat.class);
    }
}
