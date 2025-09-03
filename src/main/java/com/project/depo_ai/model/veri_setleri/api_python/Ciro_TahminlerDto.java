package com.project.depo_ai.model.veri_setleri.api_python;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ciro_TahminlerDto {
    @JsonProperty("tarih")
    private String _tarih;
    @JsonProperty("ortalama")
    private String _ortalama;
    @JsonProperty("kotu_senaryo")
    private String _kotu_senaryo;
    @JsonProperty("iyi_senaryo")
    private String _iyi_senaryo;
}
