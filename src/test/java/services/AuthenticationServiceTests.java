package services;
import onboarding.domain.AuthenticationToken;
import onboarding.repository.UserRepository;
import onboarding.services.interfaces.AuthenticationService;
import onboarding.services.AuthenticationServiceImpl;
import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import treasure.exceptions.UserAuthenticationException;
import treasure.exceptions.UserNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class AuthenticationServiceTests {

    @Mock
    private UserRepository userRepository;

    public void AuthenticationService() {
        initMocks(this);
    }

    @Test
    public void shouldBeAbleToAuthenticateAUser() {

        when(userRepository
        .getUserByUserNameAndPassWord(anyString(), anyString()))
        .thenReturn(new AuthenticationToken());

        AuthenticationService service = new AuthenticationServiceImpl(userRepository);

        AuthenticationToken authToken = service.authenticate("deonthom@gmail.com", "password");
        assertThat(authToken.getToken(), Matchers.<Matcher<? super String>>isNull(null));
    }

    @Test(expected = UserAuthenticationException.class)
    public void shouldNotBeAbleToAuthenticateAUser() {

        AuthenticationService service = new AuthenticationServiceImpl(userRepository);

        AuthenticationToken authToken = service.authenticate("", null);
        assertThat(authToken.getToken(), (Boolean) isNotNull());
        verify(userRepository, never()).getUserByUserNameAndPassWord(anyString(), anyString());
    }


    @Test(expected = UserNotFoundException.class)
    public void usershouldNotExistWhenAutheniticating() {

        when(userRepository
                .getUserByUserNameAndPassWord(anyString(), anyString()))
                .thenThrow(new UserNotFoundException());

        AuthenticationService service = new AuthenticationServiceImpl(userRepository);

        AuthenticationToken authToken = service.authenticate(anyString(), anyString());
        assertThat(authToken, (Matcher<? super AuthenticationToken>) isNull());

    }
}
