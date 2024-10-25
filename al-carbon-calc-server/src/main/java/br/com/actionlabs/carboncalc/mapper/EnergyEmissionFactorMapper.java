package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.model.EnergyEmissionFactor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnergyEmissionFactorMapper {

    EnergyEmissionFactor toModel(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO);

}
