package cz.kbpoj.fx.exercise.controller;

import cz.kbpoj.fx.exercise.api.FxApi;
import cz.kbpoj.fx.exercise.dto.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import cz.kbpoj.fx.exercise.facade.MoneyTransferFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FxController implements FxApi {

    private final MoneyTransferFacade moneyTransferFacade;

    public FxController(MoneyTransferFacade moneyTransferFacade) {
        this.moneyTransferFacade = moneyTransferFacade;
    }

    @Override
    public ResponseEntity<TargetAmount> makeTransferOfMoney(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targetCurrency) {
        return ResponseEntity.ok(
                new TargetAmount(
                        moneyTransferFacade.make(dayCourse, sourceCurrency, amount, targetCurrency).targetAmount()));
    }
}
