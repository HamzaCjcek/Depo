package com.project.depo_ai.service;

import com.project.depo_ai.model.veri_setleri.api_python.StokTahminDto;
import org.springframework.stereotype.Service;

@Service
public class YorumService {

    public String generateYorum(StokTahminDto dto) {
        double degisim = dto.getDegisimYuzde();
        String ayAdi = getAyAdi(dto.getAy());

        if (degisim > 20) {
            return ayAdi + " ayında güçlü bir artış bekleniyor (+%" + String.format("%.1f", degisim) + ").";
        } else if (degisim > 5) {
            return ayAdi + " ayında ılımlı bir artış öngörülüyor (+%" + String.format("%.1f", degisim) + ").";
        } else if (degisim > -5) {
            return ayAdi + " ayında önceki döneme göre stabil bir seyir bekleniyor (%" + String.format("%.1f", degisim) + ").";
        } else if (degisim > -20) {
            return ayAdi + " ayında hafif bir düşüş bekleniyor (" + String.format("%.1f", degisim) + "%).";
        } else {
            return ayAdi + " ayında ciddi bir azalma öngörülüyor (" + String.format("%.1f", degisim) + "%).";
        }
    }

    private String getAyAdi(int ay) {
        String[] aylar = {"Ocak","Şubat","Mart","Nisan","Mayıs","Haziran",
                "Temmuz","Ağustos","Eylül","Ekim","Kasım","Aralık"};
        if (ay >= 1 && ay <= 12) {
            return aylar[ay-1];
        }
        return "Bilinmeyen Ay";
    }
}