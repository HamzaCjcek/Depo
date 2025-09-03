package com.project.depo_ai.model.veri_setleri.ai;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class chat {
    @JsonProperty("cevap")
    private String _cevap;
    @JsonProperty("soru")
    private String _soru;

}
