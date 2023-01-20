package cz.kbpoj.fx.exercise.repository;

import cz.kbpoj.fx.exercise.entity.DailyStatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyStatementEntityRepository extends JpaRepository<DailyStatementEntity, Long> {
}
