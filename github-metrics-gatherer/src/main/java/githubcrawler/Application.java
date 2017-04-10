package githubcrawler;

import githubcrawler.service.RestGitHubFetcher;
import githubcrawler.service.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/package-summary.html
// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#_learning_about_spring_boot_features

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestController restController(){
        return new RestController();
    }

    @Bean
    public RestGitHubFetcher restFetcher(RestTemplate restTemplate) {
        return new RestGitHubFetcher(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();


    }


}