package com.project.depo_ai.controller.Stok.urunvesatis;

import com.project.depo_ai.model.veri_setleri.api_python.StokTahminDto;
import com.project.depo_ai.service.api_python.StokTahminService;
import com.project.depo_ai.service.YorumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StokTahminController {

    private final StokTahminService service;
    private final YorumService yorumService;

    public StokTahminController(StokTahminService service, YorumService yorumService) {
        this.service = service;
        this.yorumService = yorumService;
    }

    @GetMapping("/stok-tahminler")
    @ResponseBody
    public List<StokTahminDto> getTahminler(@RequestParam(defaultValue = "false") boolean yorum) {
        List<StokTahminDto> tahminler = service.getTahminler();
        if (yorum) {
            for (StokTahminDto dto : tahminler) {
                dto.setYorum(yorumService.generateYorum(dto));
            }
        }
        return tahminler;
    }

}