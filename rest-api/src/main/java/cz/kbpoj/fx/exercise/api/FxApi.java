package cz.kbpoj.fx.exercise.api;

import cz.kbpoj.fx.exercise.dto.CoursesDto;
import cz.kbpoj.fx.exercise.dto.TargetAmountDto;
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
    @GetMapping(value = "/transfer")
    default ResponseEntity<TargetAmountDto> makeTransferOfMoney(
            @RequestParam(value = "Kurz ke dni") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate dayCourse,
            @RequestParam(value = "Výchozí měna") Currency sourceCurrency,
            @RequestParam(value = "Výchozí částka") Float amount,
            @RequestParam(value = "Cílová měna") Currency targetCurrency) {
        return new ResponseEntity<>(new TargetAmountDto(null), HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiResponse(
            responseCode = "200",
            description = "Přehled kurzů v databázi pro zadaný den"
    )
    @GetMapping(value = "/courses")
    default ResponseEntity<CoursesDto> getDayCource(
            @RequestParam(value = "Kurzy ke dni") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate dayCourse) {
        return new ResponseEntity<>(new CoursesDto(null, null), HttpStatus.NOT_IMPLEMENTED);
    }
}
