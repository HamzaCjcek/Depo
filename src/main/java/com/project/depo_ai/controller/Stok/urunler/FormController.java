package com.project.depo_ai.controller.Stok.urunler;
import com.project.depo_ai.model.veri_setleri.talep_anomaliler.talep_anomalilerin_tespiti;
import com.project.depo_ai.service.anomali_talep.Anomali_Tespit_Service;
import com.project.depo_ai.service.talep_anomaliler.TalepAnomalilerinTespitiService;
import com.project.depo_ai.service.urunler.UrunlerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/form")
public class FormController {

    private final UrunlerService urunlerService;
    private final TalepAnomalilerinTespitiService talepService;
    private final Anomali_Tespit_Service anomaliService; // 🔥 yeni ekledik

    public FormController(UrunlerService urunlerService,
                          TalepAnomalilerinTespitiService talepService,
                          Anomali_Tespit_Service anomaliService) {
        this.urunlerService = urunlerService;
        this.talepService = talepService;
        this.anomaliService = anomaliService;
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("urunlerList", urunlerService.findAll());
        model.addAttribute("talepList", talepService.getAll());
        model.addAttribute("newTalep", new talep_anomalilerin_tespiti()); // form için boş obje
        model.addAttribute("yetersizListe", anomaliService.toplamTalepKiyasla());
        Map<Integer, Integer> toplamTalepMap = anomaliService.urunBazliToplamTalep();
        model.addAttribute("toplamTalepMap", toplamTalepMap);
        return "admin/form";
    }

    @PostMapping("/talep")
    public String saveTalep(@ModelAttribute("newTalep") talep_anomalilerin_tespiti talep) {
        talepService.save(talep);
        return "redirect:/form";
    }

    @GetMapping("/talep/delete/{id}")
    public String deleteTalep(@PathVariable int id) {
        talepService.delete(id);
        return "redirect:/form";
    }
}