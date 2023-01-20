package cz.kbpoj.fx.exercise.domain;

import cz.kbpoj.fx.exercise.enumeration.Currency;

public record TargetAmount(
        Float targetAmount,
        Currency targetCurrency
) {
}
