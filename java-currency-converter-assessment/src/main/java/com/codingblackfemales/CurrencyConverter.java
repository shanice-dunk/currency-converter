package com.codingblackfemales;

public interface CurrencyConverter {
    // Method for convertCurrency with parameters
    // Return converted amount 
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);
                
    // Array of currency codes
    public String[] getCurrencyCodes();
    
    // Retrieves exchange rate between two currencies
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
                
}
