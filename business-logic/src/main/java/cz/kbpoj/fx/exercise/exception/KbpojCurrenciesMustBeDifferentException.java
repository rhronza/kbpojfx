package cz.kbpoj.fx.exercise.exception;

import cz.kbpoj.fx.exercise.enumeration.Currency;

public class KbpojCurrenciesMustBeDifferentException extends RuntimeException {
    final String errorMessage;
    final Currency currency;

    public KbpojCurrenciesMustBeDifferentException(String errorMessage, Currency currency) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.currency = currency;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Currency getCurrency() {
        return currency;
    }
}
