package br.com.actionlabs.carboncalc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "energyEmissionFactor")
public class EnergyEmissionFactor {
  @Id
  private String uf;
  private double factor;
}
