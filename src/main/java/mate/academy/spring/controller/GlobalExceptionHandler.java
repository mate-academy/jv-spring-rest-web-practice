package mate.academy.spring.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import mate.academy.spring.exception.DataProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("timestamp", LocalDateTime.now().toString());
        paramsMap.put("status", status.value());
        List<String> exceptionsMessages = ex.getBindingResult().getAllErrors()
                .stream()
                .map(this::getErrorMessage)
                .collect(Collectors.toList());
        paramsMap.put("exceptions", exceptionsMessages);
        return new ResponseEntity<>(paramsMap, headers, status);
    }

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class,
            NotFoundException.class, NoSuchElementException.class,
            DataProcessingException.class, RuntimeException.class})
    private ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("timestamp", LocalDateTime.now().toString());
        paramsMap.put("exception message", ex.getMessage());
        return new ResponseEntity<>(paramsMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getErrorMessage(ObjectError objectError) {
        if (objectError instanceof FieldError) {
            String field = ((FieldError) objectError).getField();
            return field + " " + objectError.getDefaultMessage();
        }
        return objectError.getDefaultMessage();
    }
}
