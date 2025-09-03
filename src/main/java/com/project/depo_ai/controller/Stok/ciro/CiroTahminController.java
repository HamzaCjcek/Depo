package com.project.depo_ai.controller.Stok.ciro;

import com.project.depo_ai.model.veri_setleri.api_python.Ciro_TahminlerDto;
import com.project.depo_ai.service.api_python.Ciro_TahminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CiroTahminController {

    private final Ciro_TahminService service;

    @Autowired
    public CiroTahminController(Ciro_TahminService _service) {
        this.service = _service;
    }

    @GetMapping("/ciro_tahminler")
    @ResponseBody
    public List<Ciro_TahminlerDto> getCiroTahminler() {
        return service.getTahminler();
    }
}
