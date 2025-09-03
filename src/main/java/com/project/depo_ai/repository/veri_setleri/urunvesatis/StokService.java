package com.project.depo_ai.repository.veri_setleri.urunvesatis;

import com.project.depo_ai.model.veri_setleri.stok.urun_stok_aylik;

import java.util.List;

public interface StokService {
    List<urun_stok_aylik> getByUrunAndYil(int urunId, int yil);
}
