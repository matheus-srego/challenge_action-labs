package br.com.actionlabs.carboncalc.repository;

import br.com.actionlabs.carboncalc.model.UserEmissionFactor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmissionFactorRepository extends MongoRepository<UserEmissionFactor, String> {

    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber(String phoneNumber);

}
