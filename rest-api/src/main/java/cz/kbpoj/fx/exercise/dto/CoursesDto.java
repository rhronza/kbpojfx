package cz.kbpoj.fx.exercise.dto;

import java.time.LocalDate;
import java.util.List;

public record CoursesDto(
        LocalDate date,
        List<CourseDto> courseDtoList

){
}
