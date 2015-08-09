package onboarding.services;

import domain.Registration;
import domain.User;
import onboarding.exceptions.TermsAndConditionsNotAcceptedException;
import onboarding.repository.TermsAndConditionRepository;
import onboarding.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Inject
    private final TermsAndConditionRepository repository;
    @Inject
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

    public User unRegister(long registrationId) {
        if (repository.hasAcceptedTerms()) {
            return new User();
        } else {
            throw new TermsAndConditionsNotAcceptedException("Terms and conditions not accepted");
        }
    }

    @Override
    public boolean isEmailInUse(String email) {
        return false;
    }

    @Override
    public boolean isUserNameInUse(String username) {
        return false;
    }

    @Override
    public boolean logIn(String username) {
        return false;
    }

    @Override
    public boolean logOut(String username) {
        return false;
    }
}
