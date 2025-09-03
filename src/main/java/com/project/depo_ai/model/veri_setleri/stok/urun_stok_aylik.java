package com.project.depo_ai.model.veri_setleri.stok;

import com.project.depo_ai.model.veri_setleri.urunler.urunler;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "urun_stok_aylik")
@Getter
public class urun_stok_aylik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "urun_id", nullable = false) // DB’de foreign key
    private urunler urun;
    @Column(name = "yil")
    private int yil;
    @Column(name = "ay")
    private String ay;
    @Column(name = "tuketilen_miktar")
    private int tuketilen_stok_miktari;
    @Column(name = "kalan_stok")
    private int kalan_stok_miktari;
}
