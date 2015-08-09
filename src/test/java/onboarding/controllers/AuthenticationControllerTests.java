package onboarding.controllers;

import onboarding.domain.AuthenticationToken;
import onboarding.services.interfaces.AuthenticationService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import treasure.exceptions.UserAuthenticationException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTests {

    @Mock
    private AuthenticationService authenticationService;

    public AuthenticationControllerTests()
    {
        initMocks(this);
    }


    @Test
    public void shouldBeAbleToAuthenticateUser() {

        AuthenticationToken token = new AuthenticationToken();
        when(authenticationService.authenticate(anyString(),anyString())).thenReturn(token);

        AuthenticationController controller = new AuthenticationController(authenticationService);
        AuthenticationToken actualToken =  controller.login(anyString(),anyString());

        org.junit.Assert.assertEquals(token, actualToken);

        verify(authenticationService).authenticate(anyString(), anyString());
    }

    @Test(expected = UserAuthenticationException.class)
    public void shouldNotAuthenticateInvalidUser() {

        AuthenticationToken token = new AuthenticationToken();
        when(authenticationService.authenticate(anyString(), anyString())).thenThrow(UserAuthenticationException.class);

        AuthenticationController controller = new AuthenticationController(authenticationService);
        AuthenticationToken actualToken = controller.login(anyString(), anyString());

        org.junit.Assert.assertEquals(token, actualToken);
        verify(authenticationService).authenticate(anyString(), anyString());
    }

    @Test()
    public void shouldBeAbleToLogout() {
        AuthenticationController controller = new AuthenticationController(authenticationService);
        controller.logout(anyString());
        verify(authenticationService).logout(anyString());
    }
}
