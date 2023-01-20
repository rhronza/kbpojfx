package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import cz.kbpoj.fx.exercise.exception.KbpojCurrenciesMustBeDifferentException;
import cz.kbpoj.fx.exercise.service.MoneyTransferService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MoneyTransferFacadeImpl implements MoneyTransferFacade {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferFacadeImpl(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @Override
    public TargetAmount make(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targerCurrency) {
        TargetAmount targetAmount;
        if (sourceCurrency == targerCurrency) {
            throw new KbpojCurrenciesMustBeDifferentException("Source and target currencies must be different.", sourceCurrency);
        } else if (sourceCurrency == Currency.CZK) {
            targetAmount = moneyTransferService.transferFromCzkToForeignMoney(dayCourse, amount, targerCurrency);
        } else if (targerCurrency == Currency.CZK) {
            targetAmount = moneyTransferService.transferFromForeignMoneyToCzk(dayCourse, amount, targerCurrency);
        } else
            targetAmount = moneyTransferService.transferFromForeignMoneyToForeignMoney(dayCourse, sourceCurrency, amount, targerCurrency);
        return targetAmount;
    }
}
