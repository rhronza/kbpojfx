package cz.kbpoj.fx.exercise.service;

import cz.kbpoj.fx.exercise.domain.Courses;

import java.time.LocalDate;

public interface CourseService {
    Courses getDayCource(LocalDate dayCourse);
}
