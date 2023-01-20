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
    private final CurrencyCourseRepository currencyCourseRepository;
    private final DailyStatementEntityRepository dailyStatementEntityRepository;

    public InitDatabase(CurrencyCourseRepository currencyCourseRepository, DailyStatementEntityRepository dailyStatementEntityRepository) {
        this.currencyCourseRepository = currencyCourseRepository;
        this.dailyStatementEntityRepository = dailyStatementEntityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        dailyStatementEntityRepository.save(new DailyStatementEntity(null, LocalDate.parse("1995-05-13"), null));
        dailyStatementEntityRepository.save(new DailyStatementEntity(null, LocalDate.parse("1995-05-13"), null));
        dailyStatementEntityRepository.save(new DailyStatementEntity(null, LocalDate.parse("1996-05-13"), null));

        Set<CurrencyCourseEntity> courseEntities = Set.of(
                currencyCourseRepository.save(new CurrencyCourseEntity(null, "EUR", 1, 23.88F)),
                currencyCourseRepository.save(new CurrencyCourseEntity(null, "USD", 1, 22.03F)),
                currencyCourseRepository.save(new CurrencyCourseEntity(null, "INR", 100, 27.241F))
        );
        Set<CurrencyCourseEntity> courseEntitiesInserted = new HashSet<>();
        courseEntities.forEach(courseEntity -> courseEntitiesInserted.add(currencyCourseRepository.save(courseEntity)));
        DailyStatementEntity dailyStatementEntity = new DailyStatementEntity(null, LocalDate.parse("2004-05-13"), courseEntitiesInserted);
        dailyStatementEntityRepository.save(dailyStatementEntity);
    }
}
