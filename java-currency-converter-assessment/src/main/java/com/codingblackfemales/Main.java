package com.codingblackfemales;

// import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Currencies currencies = new CurrenciesGBP();
    static BasicCurrencyConverter basicCurrencyConverter = new BasicCurrencyConverter(currencies);
    static String[] currencyCodesArray = basicCurrencyConverter.getCurrencyCodes();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // DecimalFormat df = new DecimalFormat(0.00);

        String confirmConversionCodes;
        String sourceCurrencyCode;
        String destinationCurrencyCode;

        do {
            sourceCurrencyCode = requestUserCurrencyCode(true);
            destinationCurrencyCode = requestUserCurrencyCode(false);

            System.out.println("You have selected to convert from " + sourceCurrencyCode + " to " + destinationCurrencyCode + ". Please select Y to confirm. Press any other key to start again.");

            confirmConversionCodes = (scanner.nextLine()).toUpperCase();
        } while (!confirmConversionCodes.equals("Y"));

        System.out.println("Provide the amount in " + sourceCurrencyCode + " to be converted to " + destinationCurrencyCode + ".");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println((basicCurrencyConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount)) + destinationCurrencyCode);

    }

    public static boolean isValueInArray(String value, String[] array) {
        boolean isValueInArray = Arrays.asList(array).contains(value);
        return isValueInArray;
    }

    // Request and validate user input for currency codes
    public static String requestUserCurrencyCode(boolean isSourceCurrencyCode) {
        String currencyCode;

        // Select appropriate message for source code and destination code input prompt.
        String message1 = (isSourceCurrencyCode == true) ? "What currency do you have? " : "What currency would you like to convert to? ";

        // Validate the users' input. If unacceptable, print the list of available codes and prompt the user to update their choice until they choose correctly.
        do {
            System.out.println(message1 + "Please see the available currencies: " + Arrays.toString(currencyCodesArray));
            currencyCode = scanner.nextLine().toUpperCase();
        } while (currencyCode == "" || !isValueInArray(currencyCode, currencyCodesArray));

        System.out.println("You have selected " + currencyCode + ".");
        
        return currencyCode;

    }
}




        // System.out.println("Hello World!");
        // Instance of BasicCurrencyConverter
        /* CurrencyConverter converter = new BasicCurrencyConverter(null);

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
} */
