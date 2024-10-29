package br.com.actionlabs.carboncalc.validator;

import br.com.actionlabs.carboncalc.annotation.UniquePhoneNumber;
import br.com.actionlabs.carboncalc.repository.UserEmissionFactorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {

    private final UserEmissionFactorRepository userEmissionFactorRepository;

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber != null && !userEmissionFactorRepository.existsByPhoneNumber(phoneNumber);
    }

}
