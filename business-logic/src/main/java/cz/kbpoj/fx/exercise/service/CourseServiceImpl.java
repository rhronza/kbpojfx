package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.Course;
import cz.kbpoj.fx.exercise.domain.Courses;
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

@Service
public class CourseServiceImpl implements CourseService {
    private final DailyStatementEntityRepository dailyStatementEntityRepository;

    public CourseServiceImpl(DailyStatementEntityRepository dailyStatementEntityRepository) {
        this.dailyStatementEntityRepository = dailyStatementEntityRepository;
    }

    @Override
    public Courses getDayCource(LocalDate dayCourse) {
        List<DailyStatementEntity> byCourseDay = dailyStatementEntityRepository.findByCourseDay(dayCourse);

        if (byCourseDay == null || byCourseDay.isEmpty()) {
            throw new KbpojNotFoundException("Courses not found", List.of(new KeyValue("day", dayCourse.toString())));
        } else {
            Set<CurrencyCourseEntity> currencyCourseEntities = byCourseDay.get(0).getCurrencyCourseEntities();
            if (currencyCourseEntities == null || currencyCourseEntities.isEmpty()) {
                throw new KbpojNotFoundException("Courses not found", List.of(new KeyValue("day", dayCourse.toString())));
            }
        }
        return new Courses(dayCourse,
                byCourseDay.get(0).getCurrencyCourseEntities().stream()
                        .map(element -> new Course(Currency.valueOf(element.getCurrency()), element.getCourse()))
                        .toList());

    }
}
