package cz.kbpoj.fx.exercise.domain;

import java.time.LocalDate;
import java.util.List;

public record Courses(
        LocalDate date,
        List<Course> courseDtoList
) {
}
