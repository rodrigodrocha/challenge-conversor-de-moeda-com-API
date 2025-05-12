package br.com.models;


import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Moedas {

    private Map<String, Double> conversion_rates;


    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

}
