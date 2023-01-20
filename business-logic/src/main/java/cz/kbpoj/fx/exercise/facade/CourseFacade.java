package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.Courses;

import java.time.LocalDate;

public interface CourseFacade {
    Courses getDayCource(LocalDate dayCourse);
}


