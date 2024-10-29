package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.TransportationDTO;
import br.com.actionlabs.carboncalc.model.TransportationEmissionFactor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransportationEmissionFactorMapper {

    TransportationEmissionFactor toModel(TransportationDTO transportationDTO);

    List<TransportationEmissionFactor> toModelList(List<TransportationDTO> transportationDTOList);

}
