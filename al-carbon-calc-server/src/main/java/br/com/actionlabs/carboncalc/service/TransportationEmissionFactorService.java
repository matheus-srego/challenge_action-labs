package br.com.actionlabs.carboncalc.service;

import br.com.actionlabs.carboncalc.dto.TransportationDTO;

import java.util.List;

public interface TransportationEmissionFactorService {

    void save(List<TransportationDTO> transportationDTO);

    double calculate(List<TransportationDTO> transportationDTO);

}
