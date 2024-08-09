package com.codingblackfemales;

public interface CurrencyConverter {
    public static double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
                return convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);
            }
        
            public static String[] getCurrencyCodes() {
                return getCurrencyCodes();
            }
        
            public static double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
                return getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
            }
}
