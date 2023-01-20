package cz.kbpoj.fx.exercise.controller;

import cz.kbpoj.fx.exercise.api.FxApi;
import cz.kbpoj.fx.exercise.domain.Courses;
import cz.kbpoj.fx.exercise.dto.CourseDto;
import cz.kbpoj.fx.exercise.dto.CoursesDto;
import cz.kbpoj.fx.exercise.dto.TargetAmountDto;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import cz.kbpoj.fx.exercise.facade.CourseFacade;
import cz.kbpoj.fx.exercise.facade.MoneyTransferFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FxController implements FxApi {

    private final MoneyTransferFacade moneyTransferFacade;
    private final CourseFacade courseFacade;

    public FxController(MoneyTransferFacade moneyTransferFacade, CourseFacade courseFacade) {
        this.moneyTransferFacade = moneyTransferFacade;
        this.courseFacade = courseFacade;
    }

    @Override
    public ResponseEntity<TargetAmountDto> makeTransferOfMoney(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targetCurrency) {
        return ResponseEntity.ok(
                new TargetAmountDto(
                        moneyTransferFacade.make(dayCourse, sourceCurrency, amount, targetCurrency).targetAmount()));
    }

    @Override
    public ResponseEntity<CoursesDto> getDayCource(LocalDate dayCourse) {
        Courses dayCources = courseFacade.getDayCource(dayCourse);
        return ResponseEntity.ok(new CoursesDto(dayCources.date(), dayCources.courseDtoList().stream().map(e -> new CourseDto(e.currency(), e.course())).toList()));
    }
}
