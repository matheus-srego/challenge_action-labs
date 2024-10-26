package br.com.actionlabs.carboncalc.model;

import br.com.actionlabs.carboncalc.dto.TransportationDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("carbonCalculationInfo")
public class CarbonCalculationInfo {

    @Id
    private String id;
    private int energyConsumption;
    private List<TransportationDTO> transportation;
    private int solidWasteTotal;
    private double recyclePercentage;

}
