package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.dto.StartCalcResponseDTO;
import br.com.actionlabs.carboncalc.model.UserEmissionFactor;

import java.util.Optional;

public interface UserEmissionFactorService {

    StartCalcResponseDTO create(StartCalcRequestDTO startCalcRequestDTO);

    String getUF(String id);

}
