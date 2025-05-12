package br.com.models;

import com.google.gson.Gson;

public class ConvertJson {


    Gson gson = new Gson();

    public Moedas Convert(String json) {
        Moedas exchangeData = gson.fromJson(json, Moedas.class);
        return exchangeData;
    }
}
