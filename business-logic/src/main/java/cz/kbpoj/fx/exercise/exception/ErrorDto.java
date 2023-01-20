package cz.kbpoj.fx.exercise.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorDto(
        String errorMessage,
        HttpStatus httpStatus,
        List<KeyValue> descriptions
) {

}
