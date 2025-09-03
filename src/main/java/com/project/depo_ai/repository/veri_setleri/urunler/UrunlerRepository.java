package com.project.depo_ai.repository.veri_setleri.urunler;

import com.project.depo_ai.model.veri_setleri.urunler.urunler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Veri erişim katmanıdır. Veritabanı ile doğrudan iletişim kurar.
public interface UrunlerRepository extends JpaRepository<urunler, Integer> {
}
