package br.com.actionlabs.carboncalc.dto.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FieldErrorsResponseDTO {

    private int status;

    private String error;

    private String message;

    private LocalDateTime timestamp;

    private List<FieldError> errors;

    @Data
    public static class FieldError {
        private String field;
        private String message;

        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }

}
