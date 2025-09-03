package com.project.depo_ai.service.anomali_talep;

import com.project.depo_ai.model.veri_setleri.talep_anomaliler.talep_anomalilerin_tespiti;
import com.project.depo_ai.model.veri_setleri.urunler.urunler;
import com.project.depo_ai.repository.veri_setleri.talep_anomaliler.TalepAnomalilerinTespitiRepository;
import com.project.depo_ai.repository.veri_setleri.urunler.UrunlerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class Anomali_Tespit_Service {
    private TalepAnomalilerinTespitiRepository _talepAnomalilerinTespitiRepository;
    private UrunlerRepository _urunlerRepository;
    public Map<Integer, Integer> urunBazliToplamTalep() {
        List<talep_anomalilerin_tespiti> talepList = _talepAnomalilerinTespitiRepository.findAll();
        Map<Integer, Integer> toplamTalepMap = new HashMap<>();

        for (talep_anomalilerin_tespiti t : talepList) {
            toplamTalepMap.put(
                    t.getUrun_id(),
                    toplamTalepMap.getOrDefault(t.getUrun_id(), 0) + t.getTalep_miktari()
            );
        }

        return toplamTalepMap;
    }
    public List<Map<String, Object>> toplamTalepKiyasla() {
        List<talep_anomalilerin_tespiti> talepler = _talepAnomalilerinTespitiRepository.findAll();
        List<urunler> urunler = _urunlerRepository.findAll();

        List<Map<String, Object>> sonuc = new ArrayList<>();

        for (urunler urun : urunler) {
            int toplamTalep = talepler.stream()
                    .filter(t -> urun.getId() == t.getUrun_id())
                    .mapToInt(t -> t.getTalep_miktari())
                    .sum();

            if (toplamTalep > urun.getStok_miktari()) {
                Map<String, Object> map = new HashMap<>();
                map.put("urunAdi", urun.getUrun_adi());
                map.put("stok", urun.getStok_miktari());
                map.put("toplamTalep", toplamTalep);
                sonuc.add(map);
            }

        }

        return sonuc;
    }


}
