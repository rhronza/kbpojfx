package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.Courses;

import java.time.LocalDate;

/**
 * Facade for working with courses.
 */
public interface CourseFacade {
    /**
     *
     * @param dayCourse day for which exchange rate conversions are determined
     * @return object for exchange rates
     */
    Courses getDayCource(LocalDate dayCourse);
}


