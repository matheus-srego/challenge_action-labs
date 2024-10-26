package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.TransportationDTO;
import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.model.CarbonCalculationInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarbonCalculationInfoMapper {

    CarbonCalculationInfo toModel(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO);

    UpdateCalcInfoRequestDTO toDTO(String id, int energyConsumption, List<TransportationDTO> transportation, int solidWasteTotal, double recyclePercentage);

}
