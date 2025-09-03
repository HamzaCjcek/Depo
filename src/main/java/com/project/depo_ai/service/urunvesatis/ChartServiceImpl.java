package com.project.depo_ai.service.urunvesatis;

import com.project.depo_ai.model.veri_setleri.urunler.urunler;
import com.project.depo_ai.repository.veri_setleri.urunler.UrunlerRepository;
import com.project.depo_ai.repository.veri_setleri.urunvesatis.ChartService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChartServiceImpl implements ChartService {

    private final UrunlerRepository urunlerRepository;

    public ChartServiceImpl(UrunlerRepository urunlerRepository) {
        this.urunlerRepository = urunlerRepository;
    }

    @Override
    public Map<String, Object> getStokChartData() {
        List<urunler> urunlerList = urunlerRepository.findAll();

        double toplamStok = urunlerList.stream()
                .mapToDouble(urunler::getStok_miktari)
                .sum();

        List<Double> yuzdelikData = urunlerList.stream()
                .map(u -> (u.getStok_miktari() / toplamStok) * 100)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("labels", urunlerList.stream().map(urunler::getUrun_adi).collect(Collectors.toList()));
        response.put("data", yuzdelikData);

        return response;
    }
}