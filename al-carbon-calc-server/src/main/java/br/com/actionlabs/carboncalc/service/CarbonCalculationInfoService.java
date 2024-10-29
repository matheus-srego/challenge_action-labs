package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.model.CarbonCalculationInfo;

public interface CarbonCalculationInfoService {

    void save(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO);

    CarbonCalculationInfo getCarbonById(String id);

}
