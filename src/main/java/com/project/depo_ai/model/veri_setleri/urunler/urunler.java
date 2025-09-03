package com.project.depo_ai.model.veri_setleri.urunler;

import com.project.depo_ai.model.veri_setleri.stok.urun_stok_aylik;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "urunler")
@Getter
@Setter
public class urunler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String urun_adi;
    @Column
    private String kategori;
    @Column
    private String barkod_no;
    @Column
    private float birim_fiyat;
    @Column
    private int stok_miktari;
    @Column
    private int kritik_stok;
    @Column
    private Date uretim_tarihi;
    @Column
    private Date son_kullanma_tarihi;
    @OneToMany(mappedBy = "urun", cascade = CascadeType.ALL)
    private List<urun_stok_aylik> stokAylikList;
}
