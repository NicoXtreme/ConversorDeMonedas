package com.nicolasortiz.conversordemonedas.backend.modelos;

import java.util.ArrayList;
import java.util.List;

public class RespuestaCodigos {
    private String result;
    private List<List<String>> supported_codes;

    public String getResult() {
        return result;
    }

    public List<Moneda> getSupported_codes() {
        List<Moneda> monedas = new ArrayList<>();
        for (List<String> code : supported_codes) {
            monedas.add(new Moneda(code.get(0), code.get(1)));
        }
        return monedas;
    }
}
