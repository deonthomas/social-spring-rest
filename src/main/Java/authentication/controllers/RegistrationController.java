package authentication.controllers;

import domain.Registration;
import domain.User;
import onboarding.repository.TermsAndConditionRepository;
import onboarding.services.RegistrationServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping(value = "/registrations")
@EnableAutoConfiguration

public class RegistrationController {

    @Inject
    private RegistrationServiceImpl registrationService;
    @Inject
    private TermsAndConditionRepository termsAndConditionRepository;

    @Inject
    public RegistrationController(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @Inject
    public RegistrationController(RegistrationServiceImpl registrationService, TermsAndConditionRepository termsAndConditionRepository) {

        this.registrationService = registrationService;
        this.termsAndConditionRepository = termsAndConditionRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(Registration registration) {
        if (registration != null) {
            return registrationService.register(registration);
        }
        throw new IllegalArgumentException(registration.toString());
    }
}
