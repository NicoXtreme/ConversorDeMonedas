package com.nicolasortiz.conversordemonedas.backend.principal;

import com.google.gson.Gson;
import com.nicolasortiz.conversordemonedas.backend.modelos.ApiConnector;
import com.nicolasortiz.conversordemonedas.backend.modelos.Moneda;
import com.nicolasortiz.conversordemonedas.backend.modelos.RespuestaConversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ConversorMonedasGUI extends JFrame {
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField amountInput;
    private JLabel resultLabel;

    public ConversorMonedasGUI(List<Moneda> monedas) {
        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelInferior = new JPanel();
        panelInferior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelInferior.setLayout(new FlowLayout());

        fromCurrency = new JComboBox<>();
        toCurrency = new JComboBox<>();
        amountInput = new JTextField();
        resultLabel = new JLabel("Resultado: ");
        JButton convertButton = new JButton("Convertir");

        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        convertButton.setBackground(Color.BLUE);
        convertButton.setForeground(Color.WHITE);

        for (Moneda moneda : monedas) {
            fromCurrency.addItem(moneda.codigo() + " - " + moneda.nombre());
            toCurrency.addItem(moneda.codigo() + " - " + moneda.nombre());
        }

        panelSuperior.add(new JLabel("Moneda a convertir:"));
        panelSuperior.add(fromCurrency);
        panelSuperior.add(new JLabel("Moneda objetivo:"));
        panelSuperior.add(toCurrency);
        panelSuperior.add(new JLabel("Cantidad a convertir:"));
        panelSuperior.add(amountInput);

        panelInferior.add(convertButton);
        panelInferior.add(resultLabel);

        add(panelSuperior, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarConversion();
            }
        });

        setVisible(true);
    }

    private void realizarConversion() {
        try {
            String fromCurrencyCode = fromCurrency.getSelectedItem().toString().split(" ")[0];
            String toCurrencyCode = toCurrency.getSelectedItem().toString().split(" ")[0];
            double amount = Double.parseDouble(amountInput.getText());

            // Conectar con la API para obtener las tasas de conversión
            ApiConnector apiConnector = new ApiConnector();
            String conversionResponse = apiConnector.getConversionRates(fromCurrencyCode);

            // Extraer el valor de conversión de 'conversionResponse'
            double conversionRate = obtenerTasaDeConversion(conversionResponse, toCurrencyCode);

            // Mostrar el resultado
            double convertedAmount = amount * conversionRate;
            resultLabel.setText("Resultado: " + convertedAmount);

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            resultLabel.setText("Error al realizar la conversión.");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Cantidad inválida.");
        }
    }

    // Extraer la tasa de conversión desde el JSON
    private double obtenerTasaDeConversion(String jsonResponse, String toCurrencyCode) {
        Gson gson = new Gson();
        RespuestaConversion respuesta = gson.fromJson(jsonResponse, RespuestaConversion.class);
        return respuesta.getConversionRates().get(toCurrencyCode);
    }
}
