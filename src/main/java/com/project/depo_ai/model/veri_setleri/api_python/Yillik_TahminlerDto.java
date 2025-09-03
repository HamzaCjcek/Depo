package com.project.depo_ai.model.veri_setleri.api_python;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Yillik_TahminlerDto {
    @JsonProperty("urun_id")
    private int urunid;
    @JsonProperty("tuketilen_miktar")
    private int tuketilenmiktar;
    @JsonProperty("ortalama_yillik_degisim_orani")
    private double ortalamayillikdegisimorani;
    @JsonProperty("tahmin_artis")
    private int tahminartis;
    @JsonProperty("tahmin_azalis")
    private int tahminazalis;
}
