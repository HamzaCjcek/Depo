package com.project.depo_ai.controller.Stok.urunvesatis;

import com.project.depo_ai.model.veri_setleri.stok.urun_stok_aylik;
import com.project.depo_ai.repository.veri_setleri.urunvesatis.StokService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stok")
public class Stok {

    private final StokService stokService;

    public Stok(StokService stokService) {
        this.stokService = stokService;
    }
    @GetMapping("/{urunId}/{yil}")
    public List<Map<String, Object>> getStokByUrunAndYil(@PathVariable int urunId,
                                                         @PathVariable int yil) {
        List<urun_stok_aylik> stoklar = stokService.getByUrunAndYil(urunId, yil);

        // JSON dönüşü için DTO tarzında mapleyelim
        return stoklar.stream().map(s -> {
            Map<String, Object> map = new HashMap<>();
            map.put("urunId", s.getUrun().getId());
            map.put("yil", s.getYil());
            map.put("ay", s.getAy());
            map.put("tuketim", s.getTuketilen_stok_miktari());
            return map;
        }).toList();
    }
}
