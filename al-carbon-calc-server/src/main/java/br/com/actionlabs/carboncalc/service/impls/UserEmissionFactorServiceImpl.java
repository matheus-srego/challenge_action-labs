package br.com.actionlabs.carboncalc.service.impls;

import br.com.actionlabs.carboncalc.dto.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.dto.StartCalcResponseDTO;
import br.com.actionlabs.carboncalc.mapper.UserMapper;
import br.com.actionlabs.carboncalc.model.UserEmissionFactor;
import br.com.actionlabs.carboncalc.repository.UserEmissionFactorRepository;
import br.com.actionlabs.carboncalc.service.UserEmissionFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Query;
import org.bson.Document;

@Service
@RequiredArgsConstructor
public class UserEmissionFactorServiceImpl implements UserEmissionFactorService {

    private final UserMapper userMapper;

    private final UserEmissionFactorRepository userEmissionFactorRepository;

    private final MongoTemplate mongoTemplate;

    @Override
    public StartCalcResponseDTO create(StartCalcRequestDTO startCalcRequestDTO) {
        final UserEmissionFactor user = userMapper.toModel(startCalcRequestDTO);
        final UserEmissionFactor savedUser = this.userEmissionFactorRepository.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public String getUF(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        query.fields().include("uf").exclude("_id");

        Document result = this.mongoTemplate.findOne(query, Document.class, "userEmissionFactor");

        return result != null ? result.getString("uf") : null;
    }

}
