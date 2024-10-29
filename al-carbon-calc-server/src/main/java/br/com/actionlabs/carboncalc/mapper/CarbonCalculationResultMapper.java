package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.CarbonCalculationResultDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarbonCalculationResultMapper {

    default CarbonCalculationResultDTO toResultDTO(double energy, double transportation, double solidWaste) {
        final CarbonCalculationResultDTO calculationResultDTO = new CarbonCalculationResultDTO();
        calculationResultDTO.setEnergy(energy);
        calculationResultDTO.setSolidWaste(transportation);
        calculationResultDTO.setTransportation(solidWaste);
        calculationResultDTO.setTotal(energy + solidWaste + transportation);

        return calculationResultDTO;
    }

}
