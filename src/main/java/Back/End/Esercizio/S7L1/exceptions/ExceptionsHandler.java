package Back.End.Esercizio.S7L1.exceptions;


import Back.End.Esercizio.S7L1.payloads.errors.ErrorsPayloadWithList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorsPayloadWithList> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ObjectError> errorsList = ex.getBindingResult().getAllErrors();
        List<String> errorsMessages = new ArrayList<>();
        if (!errorsList.isEmpty()) {
            errorsMessages = errorsList.stream()
                    .map(err -> err.getDefaultMessage())
                    .toList();
        }
        ErrorsPayloadWithList payload = new ErrorsPayloadWithList("Errori nel body", new Date(), errorsMessages);
        return ResponseEntity.badRequest().body(payload);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorsPayloadWithList> handleBadRequest(BadRequestException e) {
        List<String> errorsMessages = new ArrayList<>();
        if (e.getErrorsList() != null) {
            errorsMessages = e.getErrorsList().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList();
        }
        ErrorsPayloadWithList payload = new ErrorsPayloadWithList(e.getMessage(), new Date(), errorsMessages);
        return ResponseEntity.badRequest().body(payload);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorsPayload> handleNotFound(NotFoundException e) {
        ErrorsPayload payload = new ErrorsPayload(e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(payload);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorsPayload> handleGeneric(Exception e) {
        log.error("Errore generico:", e);
        ErrorsPayload payload = new ErrorsPayload("Errore generico, risolveremo il prima possibile", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(payload);
    }
}