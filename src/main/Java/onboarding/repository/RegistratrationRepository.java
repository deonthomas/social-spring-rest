package onboarding.repository;

import domain.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistratrationRepository extends CrudRepository<Registration, Integer> {
}
