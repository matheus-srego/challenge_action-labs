package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.mapper.CarbonCalculationInfoMapper;
import br.com.actionlabs.carboncalc.model.CarbonCalculationInfo;
import br.com.actionlabs.carboncalc.repository.CarbonCalculationInfoRepository;
import br.com.actionlabs.carboncalc.service.CarbonCalculationInfoService;
import br.com.actionlabs.carboncalc.utils.CONSTANTS;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarbonCalculationInfoServiceImpl implements CarbonCalculationInfoService {

    private final CarbonCalculationInfoRepository calculationInfoRepository;

    private final CarbonCalculationInfoMapper calculationInfoMapper;

    @Override
    public void save(UpdateCalcInfoRequestDTO updateCalcInfoRequestDTO) {
        final CarbonCalculationInfo carbonCalculationInfo = calculationInfoMapper.toModel(updateCalcInfoRequestDTO);
        calculationInfoRepository.save(carbonCalculationInfo);
    }

    @Override
    public CarbonCalculationInfo getCarbonById(String id) {
        return calculationInfoRepository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException(CONSTANTS.CARBON_CALCULATION_NOT_FOUND + id));
    }

}
