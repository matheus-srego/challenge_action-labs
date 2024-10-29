package br.com.actionlabs.carboncalc.dto;

import br.com.actionlabs.carboncalc.utils.CONSTANTS;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCalcInfoRequestDTO {
  private String id;
  private int energyConsumption;
  private List<TransportationDTO> transportation;
  private int solidWasteTotal;
  @DecimalMin(value = "0.0", message = CONSTANTS.PERCENTAGE_DECIMAL_MIN)
  @DecimalMax(value = "1.0", message = CONSTANTS.PERCENTAGA_DECIMAL_MAX)
  private double recyclePercentage;
}
