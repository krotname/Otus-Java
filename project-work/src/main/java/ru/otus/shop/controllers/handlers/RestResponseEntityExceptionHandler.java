package ru.otus.shop.controllers.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.otus.shop.exceptions.NotFoundException;
import ru.otus.shop.models.ErrorDto;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<ErrorDto> badRequest(
            RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorDto> serviceUnavailable(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorDto> notFound(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}