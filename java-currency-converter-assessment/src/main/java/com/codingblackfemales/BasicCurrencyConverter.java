package com.codingblackfemales;

import java.util.HashMap;
import java.util.Map;

// Implements CurrencyConverter interface
public class BasicCurrencyConverter implements CurrencyConverter {
    // Create object of Currencies
    Currencies currencies;

    String[] currencyCodes;
    double conversion;

    // Constructor
    public BasicCurrencyConverter(Currencies currencies) {
        // Update Currencies object to access exchange rates
        this.currencies = currencies;
    }

    // Method to return converted amount
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        // Checks if ammount is minus value
        if (amount < 0) {
            return 0;
        }
        // Return converted amount in all other instances
        conversion = this.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
        return conversion;
    }

    // Retrieve code (keys) from hash map
    public String[] getCurrencyCodes() {
        currencyCodes = currencies.getAllExchangeRates().keySet().toArray(new String[0]);
        return currencyCodes;
    }
    
    // Calculate exchange rate between two currencies
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        // If source or destination not available
        if (this.getCurrencyExchangeRate(destinationCurrencyCode) == 0 || this.getCurrencyExchangeRate(sourceCurrencyCode) == 0) {
            return 0;
        } else {
            double exchangeRate = this.getCurrencyExchangeRate(destinationCurrencyCode)/this.getCurrencyExchangeRate(sourceCurrencyCode);
            return exchangeRate;
        }
    }

    // Return exchange rate of individial currency.
    public double getCurrencyExchangeRate(String currencyCode) {
        Double exchangeRate = currencies.getAllExchangeRates().get(currencyCode);
        return exchangeRate == null ? 0:exchangeRate; // ternary operator return 0 for null value. before colon = if cond, after = else cond
    }



    
/* 
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

    } */
}
