package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;

import java.time.LocalDate;

/**
 * Facade for working with currency tranfers.
 */
public interface MoneyTransferFacade {
    /**
     * Make a money transfer
     *
     * @param dayCourse day for which exchange rate is used
     * @param sourceCurrency source currency
     * @param amount money amount
     * @param targerCurrency target currency
     * @return object with tranfered money amount
     */
    TargetAmount make(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targerCurrency);
}
