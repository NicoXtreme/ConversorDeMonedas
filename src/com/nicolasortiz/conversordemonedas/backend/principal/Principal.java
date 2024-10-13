package com.nicolasortiz.conversordemonedas.backend.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolasortiz.conversordemonedas.backend.modelos.ApiConnector;
import com.nicolasortiz.conversordemonedas.backend.modelos.RespuestaCodigos;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        ApiConnector apiConnector = new ApiConnector();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            String codeResponse = apiConnector.getCurrencyCodes();
            RespuestaCodigos respuestaCodigos = gson.fromJson(codeResponse, RespuestaCodigos.class);

            new ConversorMonedasGUI(respuestaCodigos.getSupported_codes());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
