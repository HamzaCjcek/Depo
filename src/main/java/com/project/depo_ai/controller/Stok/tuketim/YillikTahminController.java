package com.project.depo_ai.controller.Stok.tuketim;

import com.project.depo_ai.model.veri_setleri.api_python.Yillik_TahminlerDto;
import com.project.depo_ai.service.api_python.Yillik_TahminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class YillikTahminController {

    private final Yillik_TahminService service;

    public YillikTahminController(Yillik_TahminService service) {
        this.service = service;
    }
    @GetMapping("/yillik_tahminler")
    @ResponseBody
    public List<Yillik_TahminlerDto> getYillikTahminler() {
        return service.getTahminler();
    }
}
