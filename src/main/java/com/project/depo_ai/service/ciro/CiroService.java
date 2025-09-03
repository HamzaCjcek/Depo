package com.project.depo_ai.service.ciro;

import com.project.depo_ai.model.veri_setleri.ciro.CIRO;
import com.project.depo_ai.repository.veri_setleri.ciro.CiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiroService {

    private final CiroRepository ciroRepository;

    @Autowired
    public CiroService(CiroRepository ciroRepository) {
        this.ciroRepository = ciroRepository;
    }

    public List<CIRO> findAll() {
        return ciroRepository.findAll();
    }
}
