package com.project.depo_ai.service.talep_anomaliler;

import com.project.depo_ai.model.veri_setleri.talep_anomaliler.talep_anomalilerin_tespiti;
import com.project.depo_ai.repository.veri_setleri.talep_anomaliler.TalepAnomalilerinTespitiRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TalepAnomalilerinTespitiService {

    private final TalepAnomalilerinTespitiRepository repository;

    public TalepAnomalilerinTespitiService(TalepAnomalilerinTespitiRepository repository) {
        this.repository = repository;
    }
    public List<talep_anomalilerin_tespiti> getAll() {
        return repository.findAll();
    }


    public talep_anomalilerin_tespiti save(talep_anomalilerin_tespiti  entity) {
        return repository.save(entity);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}