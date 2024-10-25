package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.dto.StartCalcResponseDTO;
import br.com.actionlabs.carboncalc.model.UserEmissionFactor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEmissionFactor toModel(StartCalcRequestDTO dto);

    StartCalcResponseDTO toResponseDTO(UserEmissionFactor user);

}
