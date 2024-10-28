package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.EnergyDTO;

public interface EnergyEmissionFactorService {

    void save(EnergyDTO energyDTO);

    double calculate(String uf, int energyConsumption);

}
