package com.codingblackfemales;

import java.util.HashMap;
import java.util.Map;

// Implements CurrencyConverter interface
public class BasicCurrencyConverter implements CurrencyConverter {
    private final Map<String, Double> exchangeRates;

    public BasicCurrencyConverter() {
        // Stores exchange rates
        exchangeRates = new HashMap<String, Double>();
            exchangeRates.put("GBP", 1.0);
            exchangeRates.put("EUR", 1.16);
            exchangeRates.put("USD", 1.31);
            exchangeRates.put("JPY", 181.78);
    }


// Override convertCurrency method
// Convert a given amount from one currency to another using the exchange rates
    @Override
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
// A key concatenating source and destination currency codes with ":" (i.e., USD:EUR)
        String key = sourceCurrencyCode + ":" + destinationCurrencyCode;
// Check if the map contains an entry and return amount * exchange rate
        if (exchangeRates.containsKey(key)) {
            return amount * exchangeRates.get(key);
        } else {
// Exeption if key does not exist
            throw new IllegalArgumentException("Exchange rate not available.");
        }
    }

// Returns list of currency codes
    @Override
    public String[] getCurrencyCodes() {
        return new String[]{"USD", "EUR", "USD", "JPY"};
    }

// Retrieves exchange rate between two currencies
// Similar to convertCurrency method 
    @Override
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        String key = sourceCurrencyCode + ":" + destinationCurrencyCode;
        if (exchangeRates.containsKey(key)) {
            return exchangeRates.get(key);
        } else {
            throw new IllegalArgumentException("Exchange rate not avaialble");
        }

    }
}
