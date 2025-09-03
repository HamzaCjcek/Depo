package com.project.depo_ai.service.urunvesatis;

import com.project.depo_ai.model.veri_setleri.stok.urun_stok_aylik;
import com.project.depo_ai.repository.veri_setleri.stok.StokRepository;
import com.project.depo_ai.repository.veri_setleri.urunvesatis.StokService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StokServiceImpl implements StokService {

    private final StokRepository stokRepository;

    public StokServiceImpl(StokRepository stokRepository) {
        this.stokRepository = stokRepository;
    }

    @Override
    public List<urun_stok_aylik> getByUrunAndYil(int urunId, int yil) {
        return stokRepository.findByUrun_IdAndYil(urunId, yil);
    }
}
