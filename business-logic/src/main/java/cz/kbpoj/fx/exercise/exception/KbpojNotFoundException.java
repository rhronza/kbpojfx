package cz.kbpoj.fx.exercise.exception;

import java.io.Serializable;
import java.util.List;

public class KbpojNotFoundException extends RuntimeException implements Serializable {
    final String errorMessage;

    final transient List<KeyValue> keyValueList;

    public KbpojNotFoundException(String errorMessage, List<KeyValue> keyValueList) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.keyValueList = keyValueList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<KeyValue> getKeyValueList() {
        return keyValueList;
    }
}
