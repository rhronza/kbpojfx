package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.Courses;

import java.time.LocalDate;

/**
 * Service for working with courses.
 */
public interface CourseService {
    /**
     * Finds the daily exchange rates for the currencies stored in the database.
     *
     * @param dayCourse day for which exchange rates is searched
     * @return object with currency courses
     */
    Courses getDayCource(LocalDate dayCourse);
}
