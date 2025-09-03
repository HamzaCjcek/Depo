package com.project.depo_ai.controller.Stok.ciro;

import com.project.depo_ai.model.veri_setleri.ciro.CIRO;
import com.project.depo_ai.service.ciro.CiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ciro")
public class CiroController {

    private final CiroService ciroService;

    @Autowired
    public CiroController(CiroService ciroService) {
        this.ciroService = ciroService;
    }

    @GetMapping
    public String viewCiroPage(Model model) {
        List<CIRO> ciroList = ciroService.findAll();
        model.addAttribute("ciroList", ciroList);
        return "admin/table";
    }
}
