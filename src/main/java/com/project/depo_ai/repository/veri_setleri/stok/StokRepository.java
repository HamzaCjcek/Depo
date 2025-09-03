package com.project.depo_ai.repository.veri_setleri.stok;

import com.project.depo_ai.model.veri_setleri.stok.urun_stok_aylik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StokRepository extends JpaRepository<urun_stok_aylik, Integer> {
    List<urun_stok_aylik> findByUrun_IdAndYil(int urunId, int yil);
}

