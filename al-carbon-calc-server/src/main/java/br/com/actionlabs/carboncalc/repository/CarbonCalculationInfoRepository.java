package br.com.actionlabs.carboncalc.repository;

import br.com.actionlabs.carboncalc.model.CarbonCalculationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarbonCalculationInfoRepository extends MongoRepository<CarbonCalculationInfo, String> {

}
