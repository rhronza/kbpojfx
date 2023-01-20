package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import cz.kbpoj.fx.exercise.exception.KbpojCurrenciesMustBeDifferentException;
import cz.kbpoj.fx.exercise.exception.KbpojDayIsOlderThenOneMonthException;
import cz.kbpoj.fx.exercise.service.MoneyTransferService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
/**
 * Implementation of {@link MoneyTransferFacade }
 */
@Service
public class MoneyTransferFacadeImpl implements MoneyTransferFacade {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferFacadeImpl(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }


    /**
     * Implementation o money transfer.
      * @param dayCourse day for which exchange rate sused
     * @param sourceCurrency source currency cource
     * @param amount money amount
     * @param targerCurrency target currency cource
     * @return  object with target money amount
     */
    @Override
    public TargetAmount make(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targerCurrency) {
        if (LocalDate.now().minusMonths(1).isAfter(dayCourse)) {
           throw new KbpojDayIsOlderThenOneMonthException("Day is older than 1 month.", dayCourse);
        }
        TargetAmount targetAmount;
        if (sourceCurrency == targerCurrency) {
            throw new KbpojCurrenciesMustBeDifferentException("Source and target currencies must be different.", sourceCurrency);
        } else if (sourceCurrency == Currency.CZK) {
            targetAmount = moneyTransferService.transferFromCzkToForeignMoney(dayCourse, amount, targerCurrency);
        } else if (targerCurrency == Currency.CZK) {
            targetAmount = moneyTransferService.transferFromForeignMoneyToCzk(dayCourse, amount, sourceCurrency);
        } else
            targetAmount = moneyTransferService.transferFromForeignMoneyToForeignMoney(dayCourse, sourceCurrency, amount, targerCurrency);
        return targetAmount;
    }
}
