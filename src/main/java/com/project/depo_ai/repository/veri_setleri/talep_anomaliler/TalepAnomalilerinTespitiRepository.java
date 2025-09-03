package com.project.depo_ai.repository.veri_setleri.talep_anomaliler;

import com.project.depo_ai.model.veri_setleri.talep_anomaliler.talep_anomalilerin_tespiti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalepAnomalilerinTespitiRepository extends JpaRepository<talep_anomalilerin_tespiti, Integer> {
}