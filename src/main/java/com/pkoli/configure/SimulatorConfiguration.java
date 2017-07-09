package com.pkoli.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

/**
 * Created by pkoli on 9/7/17.
 */
@Configuration
public class SimulatorConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        return template;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }
}
