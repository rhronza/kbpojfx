package cz.kbpoj.fx.exercise.init_memory_database;

import cz.kbpoj.fx.exercise.entity.CurrencyCourseEntity;
import cz.kbpoj.fx.exercise.entity.DailyStatementEntity;
import cz.kbpoj.fx.exercise.repository.CurrencyCourseRepository;
import cz.kbpoj.fx.exercise.repository.DailyStatementEntityRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDatabase implements ApplicationListener<ContextRefreshedEvent> {
    public static final LocalDate COURSE_DAY = LocalDate.parse("2023-01-15");
    public static final String CURRENCY_EUR = "EUR";
    public static final String CURRENCY_USD = "CURRENCY_USD";
    public static final String CURRENCY_INDIAN_RUPIE = "INR";
    public static final LocalDate COURSE_DAY_WITHOUT_COURSES = LocalDate.parse("2023-01-06");
    public static final LocalDate COURSE_DAY_DUPLICATED = LocalDate.parse("2023-01-07");
    private final CurrencyCourseRepository currencyCourseRepository;
    private final DailyStatementEntityRepository dailyStatementEntityRepository;

    public InitDatabase(CurrencyCourseRepository currencyCourseRepository, DailyStatementEntityRepository dailyStatementEntityRepository) {
        this.currencyCourseRepository = currencyCourseRepository;
        this.dailyStatementEntityRepository = dailyStatementEntityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initDaysWithoutCourses();

        initCourseDay();
    }

    private void initCourseDay() {
        Set<CurrencyCourseEntity> courseEntities = Set.of(
                currencyCourseRepository.save(new CurrencyCourseEntity(null, CURRENCY_EUR, 1, 23.88F)),
                currencyCourseRepository.save(new CurrencyCourseEntity(null, CURRENCY_USD, 1, 22.03F)),
                currencyCourseRepository.save(new CurrencyCourseEntity(null, CURRENCY_INDIAN_RUPIE, 100, 27.241F))
        );
        Set<CurrencyCourseEntity> courseEntitiesInserted = new HashSet<>();
        courseEntities.forEach(courseEntity -> courseEntitiesInserted.add(currencyCourseRepository.save(courseEntity)));
        DailyStatementEntity dailyStatementEntity = new DailyStatementEntity(null, COURSE_DAY, courseEntitiesInserted);
        dailyStatementEntityRepository.save(dailyStatementEntity);
    }

    private void initDaysWithoutCourses() {
        dailyStatementEntityRepository.save(new DailyStatementEntity(null, COURSE_DAY_WITHOUT_COURSES, null));
        dailyStatementEntityRepository.save(new DailyStatementEntity(null, COURSE_DAY_DUPLICATED, null));
        dailyStatementEntityRepository.save(new DailyStatementEntity(null, COURSE_DAY_DUPLICATED, null));
    }
}
