package com.project.depo_ai.model.veri_setleri.talep_anomaliler;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "talep_anomalilerin_tespiti")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class talep_anomalilerin_tespiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // DB’deki gerçek kolon ismi
    private int _idTalepAnomalileriniTespit;
    @Column(name = "talep_eden_firma")
    private String talep_eden_firma;
    @Column(name = "urun_id")
    private int urun_id;
    @Column(name = "talep_miktari")
    private int talep_miktari;
}
