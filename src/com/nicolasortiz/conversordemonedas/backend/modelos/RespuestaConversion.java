package com.nicolasortiz.conversordemonedas.backend.modelos;

import java.util.Map;

public class RespuestaConversion {
    private String result;
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}
