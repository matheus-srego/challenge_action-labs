package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.SolidWasteDTO;
import br.com.actionlabs.carboncalc.model.SolidWasteEmissionFactor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolidWasteEmissionFactorMapper {

    SolidWasteEmissionFactor toModel(SolidWasteDTO solidWasteDTO);

    SolidWasteDTO toDTO(String uf, double recyclableFactor, double nonRecyclableFactor);

}
