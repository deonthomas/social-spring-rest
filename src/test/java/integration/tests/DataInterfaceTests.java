package integration.tests;

import domain.Registration;
import domain.User;
import onboarding.controllers.RegistrationController;
import onboarding.repository.TermsAndConditionRepository;
import onboarding.repository.UserRepository;
import onboarding.services.RegistrationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import treasure.web.TreasureConfiguration;

import javax.inject.Inject;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TreasureConfiguration.class, DataInterfaceTests.TestApplicationConfiguration.class})
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class DataInterfaceTests extends  AbstractTestClass {

    @Value("${local.server.port}")
    protected int port;


    @Inject
    public TermsAndConditionRepository termsAndConditionRepository;

    @Inject
    public UserRepository userRepository;

    private String url;

    private URL base;

    @Inject
    protected RestTemplate template;

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
