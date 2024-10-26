package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.*;
import br.com.actionlabs.carboncalc.mapper.EnergyEmissionFactorMapper;
import br.com.actionlabs.carboncalc.mapper.SolidWasteEmissionFactorMapper;
import br.com.actionlabs.carboncalc.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarbonCalculationProcessManagerImpl implements CarbonCalculationProcessManager {

    private final UserEmissionFactorService userEmissionFactorService;

    private final CarbonCalculationInfoService carbonCalculationInfoService;

    private final EnergyEmissionFactorService energyEmissionFactorService;

    private final SolidWasteEmissionFactorService solidWasteEmissionFactorService;

    private final TransportationEmissionFactorService transportationEmissionFactorService;

    private final EnergyEmissionFactorMapper energyEmissionFactorMapper;

    private final SolidWasteEmissionFactorMapper solidWasteEmissionFactorMapper;

    @Override
    public UpdateCalcInfoResponseDTO saveCarbonInfo(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO) {
        final String uf = userEmissionFactorService.getUF(updateCalcInfoRequestDTO.getId());

        final EnergyDTO energyDTO = energyEmissionFactorMapper.toDTO(uf, updateCalcInfoRequestDTO.getEnergyConsumption());
        energyEmissionFactorService.save(energyDTO);

        final SolidWasteDTO solidWasteDTO = solidWasteEmissionFactorMapper.toDTO(uf, updateCalcInfoRequestDTO.getSolidWasteTotal(), updateCalcInfoRequestDTO.getRecyclePercentage());
        solidWasteEmissionFactorService.save(solidWasteDTO);

        transportationEmissionFactorService.save(updateCalcInfoRequestDTO.getTransportation());

        carbonCalculationInfoService.save(updateCalcInfoRequestDTO);

        final UpdateCalcInfoResponseDTO updateCalcInfoResponseDTO = new UpdateCalcInfoResponseDTO();
        updateCalcInfoResponseDTO.setSuccess(Boolean.TRUE);

        return updateCalcInfoResponseDTO;
    }

}
