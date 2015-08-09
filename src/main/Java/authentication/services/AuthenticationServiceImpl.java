package authentication.services;

import onboarding.domain.AuthenticationToken;
import onboarding.repository.UserRepository;
import onboarding.services.interfaces.AuthenticationService;
import treasure.exceptions.UserAuthenticationException;

import javax.inject.Inject;


public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;

    @Inject
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthenticationToken authenticate(String userName, String password) {
        if ((userName != "" || userName != null)
                && (password != null || password != null)) {
            return userRepository.getUserByUserNameAndPassWord(userName, password);
        }
        throw new UserAuthenticationException("Invalid user name or password");
    }

    @Override
    public void logout(String token) {

    }
}
