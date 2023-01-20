package Fenix.Exceptions.Handler;

import Fenix.Exceptions.WorshipfulMasterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MeetingExceptionHandler {
    @ExceptionHandler(WorshipfulMasterNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWorshipfulMasterNotFoundException(WorshipfulMasterNotFoundException ex) {
        ErrorResponse error = new GenericErrorResponse();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}