package cz.kbpoj.fx.exercise.api;

import cz.kbpoj.fx.exercise.dto.TargetAmount;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@RequestMapping("/kbpoj")
public interface FxApi {
    //TODO dokumentace podle https://www.baeldung.com/spring-rest-openapi-documentation
    @ApiResponse(
            responseCode = "200",
            description = "Výpočtená částka"
    )
    @GetMapping(value = "/transfer-of-money")
    default ResponseEntity<TargetAmount> makeTransferOfMoney(
            @RequestParam(value = "dayCourse") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate dayCourse,
            @RequestParam(value = "Výchozí měna") Currency sourceCurrency,
            @RequestParam(value = "Výchozí částka") Float amount,
            @RequestParam(value = "Cílová měna") Currency targetCurrency) {
        return new ResponseEntity<>(new TargetAmount(null), HttpStatus.NOT_IMPLEMENTED);
    }
}
