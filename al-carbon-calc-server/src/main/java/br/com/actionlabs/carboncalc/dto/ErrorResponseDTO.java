package br.com.actionlabs.carboncalc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private int status;

    private String error;

    private String message;

    private String path;

}
