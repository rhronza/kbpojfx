package cz.kbpoj.fx.exercise.repository;

import cz.kbpoj.fx.exercise.entity.CurrencyCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyCourseRepository extends JpaRepository<CurrencyCourseEntity, Long> {
}
