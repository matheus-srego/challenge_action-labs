package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.dto.StartCalcResponseDTO;
import br.com.actionlabs.carboncalc.mapper.UserMapper;
import br.com.actionlabs.carboncalc.model.UserEmissionFactor;
import br.com.actionlabs.carboncalc.repository.UserEmissionFactorRepository;
import br.com.actionlabs.carboncalc.service.UserEmissionFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEmissionFactorServiceImpl implements UserEmissionFactorService {

    private final UserMapper userMapper;

    private final UserEmissionFactorRepository userEmissionFactorRepository;

    public StartCalcResponseDTO create(StartCalcRequestDTO startCalcRequestDTO) {
        final UserEmissionFactor user = userMapper.toModel(startCalcRequestDTO);
        final UserEmissionFactor savedUser = this.userEmissionFactorRepository.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

}
