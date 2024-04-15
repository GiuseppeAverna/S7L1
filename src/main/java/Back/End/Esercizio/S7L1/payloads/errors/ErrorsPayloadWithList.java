package Back.End.Esercizio.S7L1.payloads.errors;

import java.util.Date;
import java.util.List;

public class ErrorsPayloadWithList {
    private final String message;
    private final Date timestamp;
    private final List<String> errorsList;

    public ErrorsPayloadWithList(String message, Date timestamp, List<String> errorsList) {
        this.message = message;
        this.timestamp = timestamp;
        this.errorsList = errorsList;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<String> getErrorsList() {
        return errorsList;
    }
}
