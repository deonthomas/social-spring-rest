package onboarding.repository;

import domain.User;
import onboarding.domain.AuthenticationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByEmail(String email);

    AuthenticationToken getUserByUserNameAndPassWord(String userName, String password);

}
