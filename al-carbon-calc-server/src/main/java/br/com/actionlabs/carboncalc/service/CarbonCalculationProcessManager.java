package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.CarbonCalculationResultDTO;
import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoResponseDTO;

public interface CarbonCalculationProcessManager {

    UpdateCalcInfoResponseDTO saveCarbonInfo(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO);

}
