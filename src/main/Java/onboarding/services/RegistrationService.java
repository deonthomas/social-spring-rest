package onboarding.services;

/**
 * Created by Deon on 8/08/2015.
 */
public interface RegistrationService {

     boolean isEmailInUse(String email) ;

     boolean isUserNameInUse(String username);

    boolean logIn(String username) ;

     boolean logOut(String username) ;
}
