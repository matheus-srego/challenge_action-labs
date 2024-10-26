package br.com.actionlabs.carboncalc.dto;

import lombok.Data;

@Data
public class SolidWasteDTO {
    private String uf;
    private double recyclableFactor;
    private double nonRecyclableFactor;
}
