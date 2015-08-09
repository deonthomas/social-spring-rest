package services;


import domain.Registration;
import domain.User;
import onboarding.exceptions.TermsAndConditionsNotAcceptedException;
import onboarding.repository.TermsAndConditionRepository;
import onboarding.repository.UserRepository;
import onboarding.services.RegistrationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import treasure.exceptions.RegistrationFailedException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    @Mock
    private TermsAndConditionRepository termsAndConditionRepository;
    @Mock
    private UserRepository userRepository;

    public RegistrationServiceTest(){
        initMocks(this);
    }

    @Test
    public void shouldBeAbleToRegisterUser() {

        RegistrationServiceImpl service = new RegistrationServiceImpl(termsAndConditionRepository, userRepository);

        when(termsAndConditionRepository.hasAcceptedTerms()).thenReturn(true);
        when(userRepository.getUserByEmail("test@test.com")).thenReturn( new User());

        service.register(new Registration());
    }

    @Test(expected = TermsAndConditionsNotAcceptedException.class)
    public void shouldNotRegisterAUserIfTermsAndConditionsNotAccepted(){

        RegistrationServiceImpl service = new RegistrationServiceImpl(termsAndConditionRepository, userRepository);

        when(termsAndConditionRepository.hasAcceptedTerms()).thenReturn(false);
        when(userRepository.getUserByEmail("test@test.com")).thenReturn( new User());

        service.register(new Registration());
        verify(userRepository.getUserByEmail(anyString()), never());
    }


    @Test(expected = RegistrationFailedException.class)
    public void shouldNotRegisterAUserIfAnExceptionOccurred() {

        RegistrationServiceImpl service = new RegistrationServiceImpl(termsAndConditionRepository, userRepository);

        when(termsAndConditionRepository.hasAcceptedTerms()).thenThrow(RegistrationFailedException.class);

        service.register(new Registration());
        verify(userRepository.getUserByEmail(anyString()), never());
    }


}
