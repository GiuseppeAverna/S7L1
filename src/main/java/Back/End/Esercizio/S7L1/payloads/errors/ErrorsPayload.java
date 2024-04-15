package Back.End.Esercizio.S7L1.payloads.errors;

import java.util.Date;

public class ErrorsPayload {
    private final String message;
    private final Date timestamp;

    public ErrorsPayload(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
