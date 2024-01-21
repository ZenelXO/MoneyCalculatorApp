package gui;

import fixerws.FixerApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ExchangeConverter implements ExchangeConverterLoader{
    private String base;
    private String symbol;
    private double amount;

    public ExchangeConverter(String base, String symbol, double amount) {
        this.base = base;
        this.symbol = symbol;
        this.amount = amount;
    }

    public double calculate() throws IOException {
        URL url = new URL("https://api.apilayer.com/exchangerates_data/latest?symbols=" + symbol.substring(0,3) + "&base=" + base.substring(0,3) + FixerApi.key);
        InputStream info = url.openStream();
        String result = new String(info.readAllBytes());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        JsonNode ratesNode = jsonNode.path("rates");
        JsonNode money = ratesNode.get(symbol.substring(0,3));

        double moneyResult = money.asDouble();
        double convertedAmount = moneyResult * amount;
        //Solo 3 decimales
        String formattedResult = String.format("%.3f", convertedAmount);
        formattedResult = formattedResult.replace(',', '.');
        return Double.parseDouble(formattedResult);
    }
}