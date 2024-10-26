package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.dto.StartCalcResponseDTO;

public interface UserEmissionFactorService {

    StartCalcResponseDTO create(StartCalcRequestDTO startCalcRequestDTO);

    String getUF(String id);

}
