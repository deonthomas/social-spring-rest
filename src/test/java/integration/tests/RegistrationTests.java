package integration.tests;

import domain.Registration;
import domain.User;
import onboarding.repository.TermsAndConditionRepository;
import onboarding.repository.UserRepository;
import onboarding.services.RegistrationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import treasure.web.TreasureApplication;
import treasure.web.TreasureConfiguration;

import javax.inject.Inject;
import java.net.URL;

public class RegistrationTests extends  AbstractTestClass {


    @Inject
    public TermsAndConditionRepository termsAndConditionRepository;

    @Inject
    public UserRepository userRepository;

    private String url;

    @Before
    public void setUp() throws Exception {
        url = resourceUrl("/");
    }


    @Test
    public void shouldGetUsRegistrationerFromDatabase(){

        RegistrationServiceImpl repository = new RegistrationServiceImpl( termsAndConditionRepository, userRepository);

        Registration registration = new Registration();
        registration.setEmail("deonthom@gmail.com");

        User user = repository.register(registration);

    }

    public static class TestApplicationConfiguration {

        @Bean
        public RestTemplate testRestTemplate() {
            RestTemplate restTemplate = new TestRestTemplate();
            return restTemplate;
        }
    }
}
