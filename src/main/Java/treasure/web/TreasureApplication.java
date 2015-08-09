package treasure.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class TreasureApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TreasureConfiguration.class, args);
    }
}
