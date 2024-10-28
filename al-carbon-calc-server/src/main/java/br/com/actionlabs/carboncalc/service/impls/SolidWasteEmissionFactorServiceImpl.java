package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.SolidWasteDTO;
import br.com.actionlabs.carboncalc.mapper.SolidWasteEmissionFactorMapper;
import br.com.actionlabs.carboncalc.model.SolidWasteEmissionFactor;
import br.com.actionlabs.carboncalc.repository.SolidWasteEmissionFactorRepository;
import br.com.actionlabs.carboncalc.service.SolidWasteEmissionFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SolidWasteEmissionFactorServiceImpl implements SolidWasteEmissionFactorService {

    private final SolidWasteEmissionFactorRepository solidWasteEmissionFactorRepository;

    private final SolidWasteEmissionFactorMapper solidWasteEmissionFactorMapper;

    @Override
    public void save(SolidWasteDTO solidWasteDTO) {
        final SolidWasteEmissionFactor solidWasteEmissionFactor = solidWasteEmissionFactorMapper.toModel(solidWasteDTO);
        solidWasteEmissionFactorRepository.save(solidWasteEmissionFactor);
    }

    @Override
    public double calculate(String uf, int solidWasteTotal, double recyclePercentage) {
        final SolidWasteEmissionFactor wasteFactor = solidWasteEmissionFactorRepository.findByUf(uf);
        final double emissionFactor = (wasteFactor.getRecyclableFactor() * recyclePercentage) +
                                      (wasteFactor.getNonRecyclableFactor() * (1 - recyclePercentage));
        
        return solidWasteTotal * emissionFactor;
    }

}
