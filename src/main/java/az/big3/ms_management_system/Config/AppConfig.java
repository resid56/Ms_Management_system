package az.big3.ms_management_system.Config;

import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${api.base.url}")
    private String baseUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }
}

