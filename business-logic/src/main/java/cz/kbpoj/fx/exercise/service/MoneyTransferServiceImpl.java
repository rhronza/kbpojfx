package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {
    @Override
    public TargetAmount transferFromCzkToForeignMoney(LocalDate dayCourse, Float amount, Currency targetMoney) {
        return new TargetAmount(100F, Currency.BRL);
    }

    @Override
    public TargetAmount transferFromForeignMoneyToCzk(LocalDate dayCourse, Float amount, Currency targetMoney) {
        return new TargetAmount(200F, Currency.BRL);
    }

    @Override
    public TargetAmount transferFromForeignMoneyToForeignMoney(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targetCurrency) {
        return new TargetAmount(300F, Currency.BRL);
    }
}
