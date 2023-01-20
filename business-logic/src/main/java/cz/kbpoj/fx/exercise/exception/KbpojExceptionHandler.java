package cz.kbpoj.fx.exercise.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class KbpojExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(KbpojExceptionHandler.class);

    @ExceptionHandler(KbpojCurrenciesMustBeDifferentException.class)
    public ResponseEntity<Object> kbpojCurrenciesMustBeDifferentExceptionHandler(KbpojCurrenciesMustBeDifferentException ex) {
        log.error(ex.getErrorMessage());
        return new ResponseEntity<>(
                new ErrorDto(
                        ex.getErrorMessage(),
                        HttpStatus.BAD_REQUEST,
                        List.of(new KeyValue("source and target currency", ex.getCurrency().toString()))),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(KbpojNotFoundException.class)
    public ResponseEntity<Object> kbpojNotFoundExceptionHandler(KbpojNotFoundException ex) {
        log.error(ex.getErrorMessage());
        return new ResponseEntity<>(
                new ErrorDto(
                        ex.getErrorMessage(),
                        HttpStatus.BAD_REQUEST,
                        ex.getKeyValueList()),
                HttpStatus.BAD_REQUEST);
    }
}
