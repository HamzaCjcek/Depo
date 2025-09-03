package com.project.depo_ai.controller.Stok.urunvesatis;

import com.project.depo_ai.repository.veri_setleri.urunvesatis.ChartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chart")
public class Chart {

    private final ChartService chartService;

    public Chart(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/stok")
    public Map<String, Object> getStokChartData() {
        return chartService.getStokChartData();
    }
}