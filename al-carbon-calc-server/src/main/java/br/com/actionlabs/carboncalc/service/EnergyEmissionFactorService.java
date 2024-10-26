package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.EnergyDTO;

public interface EnergyEmissionFactorService {

    void save(EnergyDTO energyDTO);

    double calculateEmissionFactor(EnergyDTO energyDTO);

}
