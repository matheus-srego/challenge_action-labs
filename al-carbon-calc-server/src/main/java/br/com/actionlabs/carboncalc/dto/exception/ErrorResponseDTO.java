package br.com.actionlabs.carboncalc.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private int status;

    private String error;

    private String message;

    private String path;

}
