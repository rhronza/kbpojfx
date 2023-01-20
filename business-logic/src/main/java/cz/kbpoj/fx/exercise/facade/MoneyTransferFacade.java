package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;

import java.time.LocalDate;

public interface MoneyTransferFacade {
    TargetAmount make(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targerCurrency);
}
