package com.codingblackfemales;

public interface CurrencyConverter {
    // Method for convertCurrency with parameters
    // Return converted amount 
    double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);
                
    // Array of currency codes
    String[] getCurrencyCodes();
    
    // Retrieves exchange rate between two currencies
    double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
                
}
