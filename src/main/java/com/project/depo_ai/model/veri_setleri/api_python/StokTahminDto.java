package com.project.depo_ai.model.veri_setleri.api_python;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StokTahminDto {

    @JsonProperty("urun_id")
    private int urunId;

    @JsonProperty("urun_adi")
    private String urunAdi;

    @JsonProperty("yil")
    private int yil;

    @JsonProperty("ay")
    private int ay;

    @JsonProperty("tahmin")
    private double tahmin;

    @JsonProperty("gecmis_ortalama")
    private double gecmisOrtalama;

    @JsonProperty("degisim_yuzde")
    private double degisimYuzde;

    private String yorum;
}
