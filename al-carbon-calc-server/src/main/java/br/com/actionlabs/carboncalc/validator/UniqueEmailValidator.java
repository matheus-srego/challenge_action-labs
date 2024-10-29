package br.com.actionlabs.carboncalc.validator;

import br.com.actionlabs.carboncalc.annotation.UniqueEmail;
import br.com.actionlabs.carboncalc.repository.UserEmissionFactorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserEmissionFactorRepository userEmissionFactorRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && !userEmissionFactorRepository.existsByEmail(email);
    }

}
