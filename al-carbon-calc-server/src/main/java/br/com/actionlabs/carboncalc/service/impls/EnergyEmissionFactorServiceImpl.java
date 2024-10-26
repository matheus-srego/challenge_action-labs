package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.EnergyDTO;
import br.com.actionlabs.carboncalc.mapper.EnergyEmissionFactorMapper;
import br.com.actionlabs.carboncalc.model.EnergyEmissionFactor;
import br.com.actionlabs.carboncalc.repository.EnergyEmissionFactorRepository;
import br.com.actionlabs.carboncalc.service.EnergyEmissionFactorService;
import lombok.RequiredArgsConstructor;
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

}
