package br.com.actionlabs.carboncalc.mapper;

import br.com.actionlabs.carboncalc.dto.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.dto.StartCalcResponseDTO;
import br.com.actionlabs.carboncalc.model.UserEmissionFactor;

public class UserMapper {

    public static UserEmissionFactor startCalcRequestDTOToUser(StartCalcRequestDTO dto) {
        final UserEmissionFactor user = new UserEmissionFactor();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setUf(dto.getUf());
        user.setPhoneNumber(dto.getPhoneNumber());

        return user;
    }

    public static StartCalcResponseDTO userToStartCalcResponseDTO(UserEmissionFactor user) {
        final StartCalcResponseDTO responseDTO = new StartCalcResponseDTO();
        responseDTO.setId(user.getId());

        return responseDTO;
    }

}
