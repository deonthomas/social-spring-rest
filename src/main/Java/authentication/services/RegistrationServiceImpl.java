package authentication.services;

import domain.Registration;
import domain.User;
import onboarding.exceptions.TermsAndConditionsNotAcceptedException;
import onboarding.repository.TermsAndConditionRepository;
import onboarding.repository.UserRepository;

import javax.inject.Inject;

public class RegistrationServiceImpl {

    private final TermsAndConditionRepository repository;
    private final UserRepository userRepository;

    @Inject
    public RegistrationServiceImpl(TermsAndConditionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public User register(Registration registration) {
        if (repository.hasAcceptedTerms()) {
            return new User();
        } else {
            throw new TermsAndConditionsNotAcceptedException("Terms and conditions not accepted");
        }
    }
}
