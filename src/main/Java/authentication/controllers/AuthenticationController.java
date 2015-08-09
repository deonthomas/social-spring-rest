package authentication.controllers;

import onboarding.domain.AuthenticationToken;
import onboarding.services.interfaces.AuthenticationService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;


@Controller
@RequestMapping(value = "/authentication")
@EnableAutoConfiguration
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Inject
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthenticationToken login(String userName, String password) {
        return authenticationService.authenticate(userName, password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(String token) {
        authenticationService.logout(token);
    }
}
