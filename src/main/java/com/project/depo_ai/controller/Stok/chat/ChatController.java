package com.project.depo_ai.controller.Stok.chat;

import com.project.depo_ai.model.veri_setleri.ai.chat;
import com.project.depo_ai.service.api_python.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public chat askChat(@RequestBody chat request) {
        // Service’e soruyu gönder, tek JSON cevap al
        chat response = chatService.getChatAnswer(request.get_soru());
        response.set_soru(request.get_soru()); // Kullanıcının sorusunu de ekle
        return response;
    }
}