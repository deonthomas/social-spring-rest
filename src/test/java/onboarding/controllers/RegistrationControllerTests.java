package onboarding.controllers;

import jdk.nashorn.internal.ir.annotations.Ignore;
import onboarding.services.RegistrationServiceImpl;
import onboarding.repository.TermsAndConditionRepository;
import domain.Registration;
import domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import onboarding.exceptions.TermsAndConditionsNotAcceptedException;
import treasure.exceptions.UserNotFoundException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTests {

    private static final String NAME = "Name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "confirm";
    private static final String LAST_NAME = "LastName";
    private static final String USER_NAME = "LastName";

    @Mock
    private RegistrationServiceImpl registrationService;


    @Before
    public  void Setup()
    {
        initMocks(this);
    }

    @Test
    public void shouldBeAbleToRegisterUser() {

        User user = new User();
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setConfirmPassword(CONFIRM_PASSWORD);

        when(registrationService.register(any(Registration.class)))
                .thenReturn(user);

        RegistrationController controller = new RegistrationController(registrationService,null);
        User _user = controller.registerUser(new Registration());

        Assert.assertEquals(_user.getEmail(), user.getEmail());
        Assert.assertEquals(_user.getPassword(), user.getPassword());
        Assert.assertEquals(_user.getConfirmPassword(), user.getConfirmPassword());
    }

    @Test
    public void shouldAcceptTermsAndConditionsOnRegistration() {

        User user = new User();
        user.setEmail(EMAIL);
        User.setLastName(LAST_NAME);
        User.setUserName(USER_NAME);
        user.setPassword(PASSWORD);
        user.setConfirmPassword(CONFIRM_PASSWORD);

        Registration registration = new Registration();
        registration.setAcceptTermsAndConditions(true);

        when(registrationService.register(registration))
                .thenReturn(user);

        RegistrationController controller = new RegistrationController(registrationService,null);
        User _user = controller.registerUser(registration);

        Assert.assertEquals(_user.getEmail(), user.getEmail());
        Assert.assertEquals(_user.getPassword(), user.getPassword());

        Assert.assertEquals(_user.getUserName(), user.getUserName());
        Assert.assertEquals(_user.getLastName(), user.getLastName());

        Assert.assertEquals(_user.getConfirmPassword(), user.getConfirmPassword());
    }

    @Test(expected = TermsAndConditionsNotAcceptedException.class)
    public void shouldBeAbleToHandleInvalidRegistrationWhenNoTermsAccepted() {

        User user = new User();
        user.setEmail(EMAIL);
        User.setLastName(LAST_NAME);
        User.setUserName(USER_NAME);
        user.setPassword(PASSWORD);
        user.setConfirmPassword(CONFIRM_PASSWORD);

        Registration registration = new Registration();
        registration.setAcceptTermsAndConditions(false);

        when(registrationService.register(registration))
                .thenThrow(new TermsAndConditionsNotAcceptedException("Terms not accepted"));

        RegistrationController controller = new RegistrationController(registrationService,null);
        User _user = controller.registerUser(registration);

        Assert.assertThat(_user, null);
    }


    @Test(expected = UserNotFoundException.class)
    public void shouldBeAbleToHandleFailedRegistration() {

        User user = new User();
        user.setEmail(EMAIL);
        User.setLastName(LAST_NAME);
        User.setUserName(USER_NAME);
        user.setPassword(PASSWORD);
        user.setConfirmPassword(CONFIRM_PASSWORD);

        Registration registration = new Registration();
        registration.setAcceptTermsAndConditions(false);

        when(registrationService.register(registration))
                .thenThrow(new UserNotFoundException());

        RegistrationController controller = new RegistrationController(registrationService,null);
        User _user = controller.registerUser(registration);

        Assert.assertThat(_user, null);
    }
}