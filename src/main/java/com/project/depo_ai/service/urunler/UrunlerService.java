package com.project.depo_ai.service.urunler;

import com.project.depo_ai.model.veri_setleri.urunler.urunler;
import com.project.depo_ai.repository.veri_setleri.urunler.UrunlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // İş mantığı katmanıdır.
        //Repository’den gelen verileri işler, kuralları uygular.
public class UrunlerService {
    @Autowired
    private  UrunlerRepository urunlerRepository;
    public List<urunler> findAll() {
        return urunlerRepository.findAll();
    }
}
