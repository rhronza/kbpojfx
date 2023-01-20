package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.entity.CurrencyCourseEntity;
import cz.kbpoj.fx.exercise.entity.DailyStatementEntity;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import cz.kbpoj.fx.exercise.exception.KbpojNotFoundException;
import cz.kbpoj.fx.exercise.exception.KeyValue;
import cz.kbpoj.fx.exercise.repository.DailyStatementEntityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link MoneyTransferService }
 */
@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    private final DailyStatementEntityRepository dailyStatementEntityRepository;

    public MoneyTransferServiceImpl(DailyStatementEntityRepository dailyStatementEntityRepository) {
        this.dailyStatementEntityRepository = dailyStatementEntityRepository;
    }

    @Override
    public TargetAmount transferFromCzkToForeignMoney(LocalDate dayCourse, Float amount, Currency targetCurrency) {
        CurrencyCourseEntity currencyCourseEntitiesSearched = geSearchedCourse(dayCourse, targetCurrency);

        return new TargetAmount(
                (amount / currencyCourseEntitiesSearched.getCourse()) * currencyCourseEntitiesSearched.getAmount(),
                targetCurrency);

    }

    @Override
    public TargetAmount transferFromForeignMoneyToCzk(LocalDate dayCourse, Float amount, Currency targetCurrency) {
        CurrencyCourseEntity currencyCourseEntitiesSearched = geSearchedCourse(dayCourse, targetCurrency);
        return new TargetAmount(
                (amount * currencyCourseEntitiesSearched.getCourse()) / currencyCourseEntitiesSearched.getAmount(),
                targetCurrency);
    }

    @Override
    public TargetAmount transferFromForeignMoneyToForeignMoney(LocalDate dayCourse, Currency sourceCurrency, Float amount, Currency targetCurrency) {
        TargetAmount targetAmountInCzk = this.transferFromForeignMoneyToCzk(dayCourse, amount, sourceCurrency);
        TargetAmount targetAmount = this.transferFromCzkToForeignMoney(dayCourse, targetAmountInCzk.targetAmount(), targetCurrency);
        return new TargetAmount(targetAmount.targetAmount(), targetCurrency);
    }


    /**
     * Searches course for the specified day.
     * @param dayCourse  specified day
     * @param targetCurrency currency
     * @return object with searched course
     */
    private CurrencyCourseEntity geSearchedCourse(LocalDate dayCourse, Currency targetCurrency) {
        List<DailyStatementEntity> byCourseDay = dailyStatementEntityRepository
                .findByCourseDay(dayCourse);
        if (byCourseDay == null || byCourseDay.isEmpty()) {
            throw new KbpojNotFoundException("Courses not found.", List.of(new KeyValue("day", dayCourse.toString())));
        }
        Set<CurrencyCourseEntity> currencyCourseEntities = byCourseDay.get(0).getCurrencyCourseEntities();
        if (currencyCourseEntities == null || currencyCourseEntities.isEmpty()) {
            throw new KbpojNotFoundException("Courses not found .", List.of(new KeyValue("day", dayCourse.toString()),
                    new KeyValue("list is empty", "")));
        }
        List<CurrencyCourseEntity> currencyCourseEntitiesSearched = currencyCourseEntities.stream().filter(e -> targetCurrency.name().equals(e.getCurrency())).toList();
        if (currencyCourseEntitiesSearched.isEmpty()) {
            throw new KbpojNotFoundException("Course not found .", List.of(new KeyValue("day", dayCourse.toString()),
                    new KeyValue("target currency", targetCurrency.name())));
        }
        return currencyCourseEntitiesSearched.get(0);
    }

}
