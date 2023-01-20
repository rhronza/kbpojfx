package cz.kbpoj.fx.exercise.domain;

import cz.kbpoj.fx.exercise.enumeration.Currency;

public record Course(
        Currency currency,
        Float course
) {
}
