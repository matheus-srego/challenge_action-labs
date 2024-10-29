package br.com.actionlabs.carboncalc.exception;

import br.com.actionlabs.carboncalc.dto.exception.ErrorResponseDTO;
import br.com.actionlabs.carboncalc.dto.exception.FieldErrorsResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldErrorsResponseDTO> handleValidationExceptions(MethodArgumentNotValidException exception) {
        final List<FieldErrorsResponseDTO.FieldError> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new FieldErrorsResponseDTO.FieldError(error.getField(), error.getDefaultMessage()));
        });

        final FieldErrorsResponseDTO errorResponse = new FieldErrorsResponseDTO();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Validation Error");
        errorResponse.setMessage("One or more fields have an error");
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrors(errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OpenApiResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleOpenApiResourceNotFoundException(OpenApiResourceNotFoundException exception, HttpServletRequest request) {
        final ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
