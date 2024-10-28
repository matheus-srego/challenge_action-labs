package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.SolidWasteDTO;

public interface SolidWasteEmissionFactorService {

    void save(SolidWasteDTO solidWasteDTO);

    double calculate(String uf, int solidWasteTotal, double recyclePercentage);

}
