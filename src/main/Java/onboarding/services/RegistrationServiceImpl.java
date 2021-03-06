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
    private  TermsAndConditionRepository repository;
    @Inject
    private  UserRepository userRepository;

    @Inject
    public RegistrationServiceImpl(TermsAndConditionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Inject
    public RegistrationServiceImpl(TermsAndConditionRepository repository){
        this.repository = repository;
    }

    public User register(Registration registration) {
        if (repository.hasAcceptedTerms()) {
           return  new User() ;//todo: fixup
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
