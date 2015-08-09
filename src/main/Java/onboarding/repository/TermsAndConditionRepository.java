package onboarding.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsAndConditionRepository  extends CrudRepository<Conditions, Integer  > {
    boolean hasAcceptedTerms();
}
