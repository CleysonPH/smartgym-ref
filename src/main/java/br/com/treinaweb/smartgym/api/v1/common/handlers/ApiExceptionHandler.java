package br.com.treinaweb.smartgym.api.v1.common.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import br.com.treinaweb.smartgym.core.services.token.exceptions.TokenServiceException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
        EntityNotFoundException exception, WebRequest request
    ) {
        return createResponseEntity(
            HttpStatus.NOT_FOUND,
            request,
            exception.getLocalizedMessage(),
            exception.getClass().getSimpleName()
        );
    }

    @ExceptionHandler(TokenServiceException.class)
    public ResponseEntity<Object> handleTokenServiceException(
        TokenServiceException exception, WebRequest request
    ) {
        return createResponseEntity(
            HttpStatus.UNAUTHORIZED,
            request,
            exception.getLocalizedMessage(),
            exception.getClass().getSimpleName()
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request
    ) {
        return createResponseEntity(
            status,
            request,
            "Houveram erros de validação",
            exception.getClass().getSimpleName(),
            convertFieldErrors(exception.getBindingResult().getFieldErrors())
        );
    }

    private HashMap<String, List<String>> convertFieldErrors(List<FieldError> fieldErrorList) {
        var errors = new HashMap<String, List<String>>();
        fieldErrorList.forEach(fieldError -> {
            var field = fieldError.getField();
            var message = fieldError.getDefaultMessage();
            if (errors.containsKey(field)) {
                errors.get(field).add(message);
            } else {
                var fieldErrors = new ArrayList<String>();
                fieldErrors.add(message);
                errors.put(field, fieldErrors);
            }
        });
        return errors;
    }

    private ResponseEntity<Object> createResponseEntity(
        HttpStatus status,
        WebRequest request,
        String message,
        String cause,
        Map<String, List<String>> errors
    ) {
        var path = ((ServletWebRequest)request).getRequest().getRequestURI();
        var body = ErrorResponse.builder()
            .status(status.value())
            .cause(cause)
            .message(message)
            .path(path)
            .timestamp(LocalDateTime.now())
            .errors(errors)
            .build();

        return new ResponseEntity<>(body, status);
    }

    private ResponseEntity<Object> createResponseEntity(
        HttpStatus status, WebRequest request, String message, String cause
    ) {
        return createResponseEntity(status, request, message, cause, null);
    }

}
