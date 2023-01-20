package cz.kbpoj.fx.exercise.dto;

import cz.kbpoj.fx.exercise.enumeration.Currency;

public record CourseDto(
        Currency currency,
        Float course
) {


}
