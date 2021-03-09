package com.porodnov.demo.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IdPeriod {
    @JsonProperty("id_start")
    private int idStart;
    @JsonProperty("id_end")
    private int idEnd;
}
