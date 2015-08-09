package onboarding.services.interfaces;

import onboarding.domain.AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    AuthenticationToken authenticate(String userName, String password);

    void logout(String token);

}
