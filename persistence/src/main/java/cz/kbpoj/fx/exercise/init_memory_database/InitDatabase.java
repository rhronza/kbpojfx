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
    public static final String CURRENCY_EUR = "EUR";
    public static final String CURRENCY_USD = "USD";
    public static final String CURRENCY_INDIAN_RUPIE = "INR";
    public static final int CURRENCY_AMOUNT_INR = 100;
    public static final int CURRENCY_AMOUNT_FOR_EUR_AND_USD = 1;
    public static final float EUR_COURSE_DEFAULT = 23.88F;
    public static final float USD_COURSE_DEFAULT = 22.03F;
    public static final float INR_COURSE_DEFAULT = 27.241F;
    private final CurrencyCourseRepository currencyCourseRepository;
    private final DailyStatementEntityRepository dailyStatementEntityRepository;

    public InitDatabase(CurrencyCourseRepository currencyCourseRepository, DailyStatementEntityRepository dailyStatementEntityRepository) {
        this.currencyCourseRepository = currencyCourseRepository;
        this.dailyStatementEntityRepository = dailyStatementEntityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        float diff = 0.1F;
        for (int i = 0; i < 31; i++) {
            initCourseDay(LocalDate.now().minusDays(i), EUR_COURSE_DEFAULT - (diff * i), USD_COURSE_DEFAULT - (diff * i), INR_COURSE_DEFAULT - (diff * i));
        }
    }

    private void initCourseDay(LocalDate date, float eurCourse, float usdCourse, float inrCourse) {
        Set<CurrencyCourseEntity> courseEntities = Set.of(
                currencyCourseRepository.save(new CurrencyCourseEntity(null, CURRENCY_EUR, CURRENCY_AMOUNT_FOR_EUR_AND_USD, eurCourse)),
                currencyCourseRepository.save(new CurrencyCourseEntity(null, CURRENCY_USD, CURRENCY_AMOUNT_FOR_EUR_AND_USD, usdCourse)),
                currencyCourseRepository.save(new CurrencyCourseEntity(null, CURRENCY_INDIAN_RUPIE, CURRENCY_AMOUNT_INR, inrCourse))
        );
        Set<CurrencyCourseEntity> courseEntitiesInserted = new HashSet<>();
        courseEntities.forEach(courseEntity -> courseEntitiesInserted.add(currencyCourseRepository.save(courseEntity)));
        DailyStatementEntity dailyStatementEntity = new DailyStatementEntity(null, date, courseEntitiesInserted);
        dailyStatementEntityRepository.save(dailyStatementEntity);
    }
}
