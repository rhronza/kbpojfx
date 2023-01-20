package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface MoneyTransferService {
    TargetAmount transferFromCzkToForeignMoney(LocalDate dayCourse, Float amount, Currency targetCurrency);

    TargetAmount transferFromForeignMoneyToCzk(LocalDate dayCourse, Float amount, Currency targetCurrency);

    TargetAmount transferFromForeignMoneyToForeignMoney(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targetCurrency);
}
