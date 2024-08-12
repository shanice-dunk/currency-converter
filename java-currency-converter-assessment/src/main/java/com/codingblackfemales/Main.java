package com.codingblackfemales;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // Instance of BasicCurrencyConverter
        CurrencyConverter converter = new BasicCurrencyConverter();

        // Convert 200 USD to EUR
        double convertedAmount = converter.convertCurrency("USD", "EUR", 200);
        System.out.println("Converted Amount: " + convertedAmount);

        // Get exchange rate between USD and EUR
        double exchangeRate = converter.getExchangeRate("USD", "EUR");
        System.out.println("Exchnage rate (USD to EUR): " + exchangeRate);

        // Get list of currency codes
        String[] currencyCodes = converter.getCurrencyCodes();
        System.out.println("Currency codes that are available: " + currencyCodes);
    }
}
