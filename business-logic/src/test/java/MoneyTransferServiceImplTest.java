import cz.kbpoj.fx.exercise.domain.TargetAmount;
import cz.kbpoj.fx.exercise.entity.CurrencyCourseEntity;
import cz.kbpoj.fx.exercise.entity.DailyStatementEntity;
import cz.kbpoj.fx.exercise.enumeration.Currency;
import cz.kbpoj.fx.exercise.repository.DailyStatementEntityRepository;
import cz.kbpoj.fx.exercise.service.MoneyTransferServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MoneyTransferServiceImplTest {
    public static final float COURSE = 22.22F;
    public static final float AMOUNT = 44F;
    @Mock
    private DailyStatementEntityRepository dailyStatementEntityRepository;

    @InjectMocks
    private MoneyTransferServiceImpl moneyTransferService;

    @Test
    void transferFromCzkToForeignMoneyTest() {
        List<DailyStatementEntity> dailyStatementEntityList =
                List.of(
                        new DailyStatementEntity(100L, LocalDate.parse("2020-05-05"),
                                Set.of(new CurrencyCourseEntity(200L, "USD", 1, COURSE))));
        when(dailyStatementEntityRepository.findByCourseDay(any()))
                .thenReturn(dailyStatementEntityList);

        TargetAmount targetAmount = moneyTransferService.transferFromCzkToForeignMoney(LocalDate.parse("2020-05-05"), AMOUNT, Currency.USD);
        assertEquals(Currency.USD, targetAmount.targetCurrency());
        assertEquals(AMOUNT/COURSE, targetAmount.targetAmount());
    }
}
