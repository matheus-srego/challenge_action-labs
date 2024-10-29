package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.EnergyDTO;
import br.com.actionlabs.carboncalc.mapper.EnergyEmissionFactorMapper;
import br.com.actionlabs.carboncalc.model.EnergyEmissionFactor;
import br.com.actionlabs.carboncalc.repository.EnergyEmissionFactorRepository;
import br.com.actionlabs.carboncalc.service.EnergyEmissionFactorService;
import br.com.actionlabs.carboncalc.utils.CONSTANTS;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnergyEmissionFactorServiceImpl implements EnergyEmissionFactorService {

    private final EnergyEmissionFactorRepository energyEmissionFactorRepository;

    private final EnergyEmissionFactorMapper energyEmissionFactorMapper;

    @Override
    public void save(EnergyDTO energyDTO) {
        final EnergyEmissionFactor energyEmissionFactor = energyEmissionFactorMapper.toModel(energyDTO);
        energyEmissionFactorRepository.save(energyEmissionFactor);
    }

    @Override
    public double calculate(String ufId, int energyConsumption) {
        final EnergyEmissionFactor energyFactor = energyEmissionFactorRepository.findById(ufId).orElseThrow(() -> new OpenApiResourceNotFoundException(CONSTANTS.ENERGY_EMISSION_NOT_FOUND + ufId));
        return energyConsumption * energyFactor.getFactor();
    }

}
