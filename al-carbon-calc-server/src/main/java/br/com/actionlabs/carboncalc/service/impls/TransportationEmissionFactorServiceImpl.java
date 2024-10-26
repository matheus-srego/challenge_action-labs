package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.TransportationDTO;
import br.com.actionlabs.carboncalc.mapper.TransportationEmissionFactorMapper;
import br.com.actionlabs.carboncalc.model.TransportationEmissionFactor;
import br.com.actionlabs.carboncalc.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.service.TransportationEmissionFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportationEmissionFactorServiceImpl implements TransportationEmissionFactorService {

    private final TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    private final TransportationEmissionFactorMapper transportationEmissionFactorMapper;

    @Override
    public void save(List<TransportationDTO> transportationDTO) {
        final List<TransportationEmissionFactor> transportationEmissionFactor = transportationEmissionFactorMapper.toModelList(transportationDTO);
        transportationEmissionFactorRepository.saveAll(transportationEmissionFactor);
    }

}
