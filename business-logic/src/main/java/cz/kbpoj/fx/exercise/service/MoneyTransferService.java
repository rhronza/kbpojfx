package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
/**
 * Service for working with currency tranfers.
 */
@Service
public interface MoneyTransferService {
    /**
     * Transfer from CZK to foreing currency.
     *
     * @param dayCourse  specified day
     * @param amount    money amount
     * @param targetCurrency  target currency
     * @return object with transfered money amount
     */
    TargetAmount transferFromCzkToForeignMoney(LocalDate dayCourse, Float amount, Currency targetCurrency);

    /**
     * Transfer from foreing currency to CZK.
     *
     * @param dayCourse specified day
     * @param amount   money amount
     * @param targetCurrency  target currency
     * @return object with transfered money amount
     */
    TargetAmount transferFromForeignMoneyToCzk(LocalDate dayCourse, Float amount, Currency targetCurrency);

    /**
     *   Transfer from foreign currency to other foreing currency.
     *
     * @param dayCourse  specified day
     * @param sourceCurrency  source currency
     * @param amount   money amount
     * @param targetCurrency target currency
     * @return  object with transfered money amount
     */
    TargetAmount transferFromForeignMoneyToForeignMoney(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targetCurrency);
}
