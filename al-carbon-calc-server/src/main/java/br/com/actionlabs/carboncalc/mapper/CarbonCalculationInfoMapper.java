package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.model.CarbonCalculationInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarbonCalculationInfoMapper {

    CarbonCalculationInfo toModel(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO);

}
