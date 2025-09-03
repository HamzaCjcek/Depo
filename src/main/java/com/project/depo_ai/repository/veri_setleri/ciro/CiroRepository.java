package com.project.depo_ai.repository.veri_setleri.ciro;

import com.project.depo_ai.model.veri_setleri.ciro.CIRO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiroRepository extends JpaRepository<CIRO, Integer> {
}
