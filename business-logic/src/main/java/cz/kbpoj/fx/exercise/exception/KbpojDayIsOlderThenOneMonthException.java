package cz.kbpoj.fx.exercise.exception;

import java.time.LocalDate;

public class KbpojDayIsOlderThenOneMonthException extends RuntimeException {
    final String errorMessage;
    final LocalDate date;


    public KbpojDayIsOlderThenOneMonthException(String errorMessage, LocalDate date) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.date = date;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDate getDate() {
        return date;
    }
}
